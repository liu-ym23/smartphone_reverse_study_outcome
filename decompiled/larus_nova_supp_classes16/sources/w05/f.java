package w05;

import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.DocObjInfo;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import io.reactivex.functions.BiFunction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f<T1, T2, R> implements BiFunction {
    public static final f<T1, T2, R> a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final Object apply(Object r5, Object r6) {
        DocumentInfo r7 = (DocumentInfo) r5;
        DocObjInfo r8 = (DocObjInfo) r6;
        Intrinsics.checkNotNullParameter(r7, "document");
        Intrinsics.checkNotNullParameter(r8, "objInfo");
        r7.setDocObjInfo(r8);
        DocMetaInfo r0 = r7.getDocMetaInfo();
        boolean r2 = true;
        if (r7.getDocMetaInfo().isPined() == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        r0.setPined(r1);
        DocMetaInfo r3 = r7.getDocMetaInfo();
        if (r7.getDocMetaInfo().isStared() == false) goto L12;
    L15:
        r3.setStared(r2);
        return r7;
    L12:
        if (r8.isStared() == true) goto L15;
        r2 = false;
        goto L15
    L5:
        if (r8.isPined() == true) goto L8;
        r1 = false;
        goto L9
    }
}
