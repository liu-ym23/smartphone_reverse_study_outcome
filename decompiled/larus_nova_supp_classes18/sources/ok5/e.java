package ok5;

import com.bytedance.ee.bear.bitable.jsapi.BitableJSApiErrorCode;
import com.bytedance.ee.bear.bitable.jsapi.common.CommonAttachmentPanel;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import na8.p;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements CommonAttachmentPanel.d {
    public final /* synthetic */ gk5.a a;

    public e(p r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a(List<CommonAttachmentPanel.AttachmentInfo> r9) {
        gk5.a r0 = this.a;
        JSONObject r1 = new JSONObject();
        if (r9 != null) goto L5;
        r9 = CollectionsKt.emptyList();
    L5:
        Intrinsics.checkNotNullParameter(r9, "<this>");
        JSONArray r2 = new JSONArray();
        Iterator<T> r10 = r9.iterator();
    L7:
        if (r10.hasNext() == false) goto L18;
        CommonAttachmentPanel.AttachmentInfo r3 = (CommonAttachmentPanel.AttachmentInfo) r10.next();
        JSONObject r4 = new JSONObject();
        r4.put("attachmentID", r3.getAttachmentID());
        r4.put("mimeType", r3.getMimeType());
        r4.put("size", r3.getSize());
        r4.put("name", r3.getName());
        String r5 = r3.getBase64Image();
        if (r5 == null) goto L11;
        r4.put("base64Image", r5);
    L11:
        Integer r6 = r3.getWidth();
        if (r6 == null) goto L14;
        r4.put("width", r6.intValue());
    L14:
        Integer r7 = r3.getHeight();
        if (r7 == null) goto L17;
        r4.put("height", r7.intValue());
    L17:
        r2.put(r4);
        goto L7
    L18:
        r1.put("infos", r2);
        r0.onSuccess(r1);
    }

    public final void b(int r3, String r4) {
        gk5.a r5 = this.a;
        BitableJSApiErrorCode r0 = BitableJSApiErrorCode.UNKNOWN;
        int r1 = r0.getCode();
        if (r4 != null) goto L5;
        r4 = r0.getErrMsg();
    L5:
        r5.onFailure(r1, r4);
    }
}
