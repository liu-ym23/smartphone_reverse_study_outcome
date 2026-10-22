package ih5;

import android.content.Context;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larksuite.component.universe_design.image.UDAvatarList;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends UDAvatarList.AvatarAdapter<UserInfo> {
    public a a;
    public Boolean b;
    public ArrayList<UserInfo> c;
    public int d;
    public Boolean e;

    public interface a {
        void a(UserInfo r1);
    }

    public c() {
        super(-3, new ArrayList());
        this.b = Boolean.TRUE;
        this.d = 0;
        this.e = Boolean.FALSE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        if (this.c != null) goto L5;
        return;
    L5:
        List r0 = getData();
        r0.clear();
        r0.addAll(this.c);
        tt5.a.h("CollaboratorAvatarAdapter", "refreshView size " + this.c.size() + " total " + this.d + " enable " + this.b);
        if (this.b.booleanValue() == true) goto L8;
    L9:
        int r1 = this.d - this.c.size();
    L10:
        int r2 = r1 - 1;
        if (r1 <= 0) goto L13;
        r0.add(new UserInfo());
        r1 = r2;
    L13:
        notifyDataSetChanged();
        return;
    L8:
        if (this.c.size() <= 5) goto L13;
        goto L9
    }

    static {
    }

    public final UDAvatar getAvatar(Context r2, int r3) {
        if (r3 >= 0) goto L6;
        return null;
    L6:
        if (this.e.booleanValue() == false) goto L14;
        if (this.b.booleanValue() == true) goto L14;
        if (r3 != 1) goto L14;
        return getMoreAvatar(r2);
    L14:
        return super.getAvatar(r2, r3);
    }

    public final void onItemCreated(UDAvatar r2, int r3) {
        final UserInfo r4 = (UserInfo) getItem(r3);
        if (r4 == null) goto L6;
        pg5.a.b(r2, r4);
        r2.setOnClickListener(new b(this, r4));
        return;
    }
}
