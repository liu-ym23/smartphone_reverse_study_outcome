package w05;

import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.DocObjInfo;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import io.reactivex.functions.BiFunction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class f<T1, T2, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f<T1, T2, R> f557785a = null;

    static {
        f557785a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r100, Object r101) {
        DocumentInfo r102 = (DocumentInfo) r100;
        DocObjInfo r103 = (DocObjInfo) r101;
        Intrinsics.checkNotNullParameter(r102, "document");
        Intrinsics.checkNotNullParameter(r103, "objInfo");
        r102.setDocObjInfo(r103);
        DocMetaInfo r104 = r102.getDocMetaInfo();
        boolean r105 = true;
        if (r102.getDocMetaInfo().isPined() == false) goto L5;
    L8:
        boolean r106 = true;
    L9:
        r104.setPined(r106);
        DocMetaInfo r107 = r102.getDocMetaInfo();
        if (r102.getDocMetaInfo().isStared() == false) goto L12;
    L15:
        r107.setStared(r105);
        return r102;
    L12:
        if (r103.isStared() == true) goto L15;
        r105 = false;
        goto L15
    L5:
        if (r103.isPined() == true) goto L8;
        r106 = false;
        goto L9
    }
}
