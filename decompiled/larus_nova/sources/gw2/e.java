package gw2;

import com.bytedance.android.livehostapi.business.depend.publish.MatchPublishStatusListener;
import com.bytedance.android.livehostapi.business.depend.publish.MatchRecordStatus;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements MatchPublishStatusListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<c> f483026a = null;

    @Override // com.bytedance.android.livehostapi.business.depend.publish.MatchPublishStatusListener
    public final String getPublishId() {
        return "MatchPublishManager";
    }

    static {
        f483026a = new LinkedHashSet();
    }

    public static void a(MatchRecordStatus r100, int r101, String r102) {
        if (r100 == null) goto L55;
        int r103 = d.f483025a[r100.ordinal()];
        if (r103 != 1) goto L7;
        Set<c> r104 = f483026a;
        if (r104 == null) goto L54;
        Iterator<T> r105 = r104.iterator();
    L43:
        if (r105.hasNext() == false) goto L61;
        ((c) r105.next()).eg(r102);
        goto L43
    L61:
        return;
    L54:
        return;
    L7:
        if (r103 != 2) goto L9;
        Set<c> r106 = f483026a;
        if (r106 == null) goto L53;
        Iterator<T> r107 = r106.iterator();
    L37:
        if (r107.hasNext() == false) goto L60;
        ((c) r107.next()).tk();
        goto L37
    L60:
        return;
    L53:
        return;
    L9:
        if (r103 != 3) goto L11;
        Set<c> r108 = f483026a;
        if (r108 == null) goto L52;
        Iterator<T> r109 = r108.iterator();
    L31:
        if (r109.hasNext() == false) goto L59;
        ((c) r109.next()).wo();
        goto L31
    L59:
        return;
    L52:
        return;
    L11:
        if (r103 != 4) goto L13;
        Set<c> r110 = f483026a;
        if (r110 == null) goto L51;
        Iterator<T> r111 = r110.iterator();
    L25:
        if (r111.hasNext() == false) goto L58;
        ((c) r111.next()).onSuccess(r102);
        goto L25
    L58:
        return;
    L51:
        return;
    L13:
        if (r103 != 5) goto L56;
        Set<c> r112 = f483026a;
        if (r112 == null) goto L45;
        Iterator<T> r113 = r112.iterator();
    L19:
        if (r113.hasNext() == false) goto L57;
        ((c) r113.next()).hc(r101, r102);
        goto L19
    L57:
        return;
    L45:
        return;
    L56:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.publish.MatchPublishStatusListener
    public final void onFinish(MatchRecordStatus r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "publishId");
        a(r100, 0, r102);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.publish.MatchPublishStatusListener
    public final void onProgress(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "publishId");
        a(MatchRecordStatus.PROGRESS, r100, r102);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.publish.MatchPublishStatusListener
    public final void onStageUpdate(MatchRecordStatus r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "publishId");
        a(r100, 0, r102);
    }
}
