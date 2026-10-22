package q9b;

import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.mvp.BaseModel;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.contact.impl.group.join.MyJoinGroupFragment;
import com.ss.android.lark.contact.impl.group.manage.MyManageGroupFragment;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public final class e extends BaseModel implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f532189a;

    public e(d r100) {
        this.f532189a = r100;
    }

    @Override // q9b.k
    public final List B7(FragmentActivity r100) {
        ArrayList r101 = new ArrayList();
        MyManageGroupFragment r102 = new MyManageGroupFragment();
        r102.f419501g = this.f532189a;
        MyJoinGroupFragment r103 = new MyJoinGroupFragment();
        r103.f419479e = this.f532189a;
        r101.add(new com.ss.android.lark.base.fragment.a(r102, UIUtils.getString(r100, R.string.Lark_Groups_MyGroups)));
        r101.add(new com.ss.android.lark.base.fragment.a(r103, UIUtils.getString(r100, R.string.Lark_Legacy_GroupJoinedGroup)));
        return r101;
    }
}
