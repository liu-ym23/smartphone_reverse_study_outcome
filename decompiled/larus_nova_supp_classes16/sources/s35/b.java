package s35;

import com.bytedance.ee.bear.BlockSimpleInfo;
import com.bytedance.ee.bear.share.export.BitableShareRoleMember;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public String a;
    public String b;
    public String c;
    public String d;
    public final ArrayList<Integer> e;
    public final ArrayList<Integer> f;
    public boolean g;
    public ArrayList<BlockSimpleInfo> h;
    public ArrayList<BlockSimpleInfo> i;
    public boolean j;
    public ArrayList<BitableShareRoleMember> k;
    public a l;

    public final String toString() {
        return "ShareItemModel{id='" + du5.b.g(null) + "', title='" + du5.b.g(this.a) + "', url='" + du5.b.g(this.b) + "', content='" + du5.b.g(this.c) + "', topic='" + du5.b.g(this.d) + "', disabledShareTypes=" + this.e + ", badgeShareTypes=" + this.f + ", menuCallback=" + this.l + '}';
    }

    public b() {
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
    }
}
