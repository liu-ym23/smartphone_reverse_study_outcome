package ih5;

import android.content.Context;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larksuite.component.universe_design.image.UDAvatarList;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends UDAvatarList.AvatarAdapter<UserInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f489862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f489863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList<UserInfo> f489864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f489865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f489866e;

    public interface a {
        void a(UserInfo r100);
    }

    public c() {
        super(-3, new ArrayList());
        this.f489863b = Boolean.TRUE;
        this.f489865d = 0;
        this.f489866e = Boolean.FALSE;
    }

    public final void a() {
        if (this.f489864c != null) goto L5;
        return;
    L5:
        List<UserInfo> r100 = getData();
        r100.clear();
        r100.addAll(this.f489864c);
        tt5.a.h("CollaboratorAvatarAdapter", "refreshView size " + this.f489864c.size() + " total " + this.f489865d + " enable " + this.f489863b);
        if (this.f489863b.booleanValue() == true) goto L8;
    L9:
        int r101 = this.f489865d - this.f489864c.size();
    L10:
        int r102 = r101 - 1;
        if (r101 <= 0) goto L13;
        r100.add(new UserInfo());
        r101 = r102;
    L13:
        notifyDataSetChanged();
        return;
    L8:
        if (this.f489864c.size() <= 5) goto L13;
        goto L9
    }

    static {
    }

    @Override // com.larksuite.component.universe_design.image.UDAvatarList.AvatarAdapter
    public final UDAvatar getAvatar(Context r100, int r101) {
        if (r101 >= 0) goto L6;
        return null;
    L6:
        if (this.f489866e.booleanValue() == false) goto L14;
        if (this.f489863b.booleanValue() == true) goto L14;
        if (r101 != 1) goto L14;
        return getMoreAvatar(r100);
    L14:
        return super.getAvatar(r100, r101);
    }

    @Override // com.larksuite.component.universe_design.image.UDAvatarList.AvatarAdapter
    public final void onItemCreated(UDAvatar r100, int r101) {
        final UserInfo r102 = getItem(r101);
        if (r102 == null) goto L6;
        pg5.a.b(r100, r102);
        r100.setOnClickListener(new b(this, r102));
        return;
    }
}
