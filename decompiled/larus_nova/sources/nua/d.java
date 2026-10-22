package nua;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.passportc.impl.v2.entity.d f520613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<User> f520614b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.ss.android.lark.passportc.impl.v2.entity.d f520615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<User> f520616b;

        public a() {
        }
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("foreground:");
        r100.append(this.f520613a);
        r100.append(" validUsers:");
        List<User> r101 = this.f520614b;
        if (r101 == null) goto L8;
        List<User> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L9;
        r103.add(((User) r104.next()).userId);
    L9:
        r100.append(r103);
        return r100.toString();
    L8:
        r103 = null;
        goto L9
    }

    public d(com.ss.android.lark.passportc.impl.v2.entity.d r100, List r101) {
        this.f520613a = r100;
        this.f520614b = r101;
    }
}
