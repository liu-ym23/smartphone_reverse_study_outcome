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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final List<ICommentComponent> a(CommentGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$getChildComponents");
        ArrayList r0 = new ArrayList();
        String r1 = r3.getViewType();
        if (Intrinsics.areEqual(r1, ComponentViewType.LYNX.getType()) == false) goto L8;
        CommentLynxComponent r4 = r3.getLynx();
        if (r4 == null) goto L20;
        r0.add(r4);
    L20:
        return r0;
    L8:
        if (Intrinsics.areEqual(r1, ComponentViewType.SLICE.getType()) == false) goto L16;
        List<CommentSliceComponent> r5 = r3.getSlices();
        if (r5 == null) goto L20;
        Iterator<T> r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L20;
        r0.add((CommentSliceComponent) r6.next());
        goto L13
    L16:
        if (Intrinsics.areEqual(r1, ComponentViewType.NATIVE.getType()) == false) goto L20;
        CommentNativeComponent r7 = r3.getNative();
        if (r7 == null) goto L20;
        r0.add(r7);
        goto L20
    }
}
