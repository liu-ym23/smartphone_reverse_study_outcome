package jc3;

import com.bytedance.android.shopping.commentv3.data.ComponentViewType;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentGroup;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentLynxComponent;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentNativeComponent;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentSliceComponent;
import com.bytedance.android.shopping.commentv3.data.interfaces.ICommentComponent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {
    public static final List<ICommentComponent> a(CommentGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getChildComponents");
        ArrayList r101 = new ArrayList();
        String r102 = r100.getViewType();
        if (Intrinsics.areEqual(r102, ComponentViewType.LYNX.getType()) == false) goto L8;
        CommentLynxComponent r103 = r100.getLynx();
        if (r103 == null) goto L20;
        r101.add(r103);
    L20:
        return r101;
    L8:
        if (Intrinsics.areEqual(r102, ComponentViewType.SLICE.getType()) == false) goto L16;
        List<CommentSliceComponent> r104 = r100.getSlices();
        if (r104 == null) goto L20;
        Iterator<T> r105 = r104.iterator();
    L13:
        if (r105.hasNext() == false) goto L20;
        r101.add((CommentSliceComponent) r105.next());
        goto L13
    L16:
        if (Intrinsics.areEqual(r102, ComponentViewType.NATIVE.getType()) == false) goto L20;
        CommentNativeComponent r106 = r100.getNative();
        if (r106 == null) goto L20;
        r101.add(r106);
        goto L20
    }
}
