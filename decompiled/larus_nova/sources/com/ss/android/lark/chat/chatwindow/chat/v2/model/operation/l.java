package com.ss.android.lark.chat.chatwindow.chat.v2.model.operation;

import com.bytedance.lark.pb.basic.v1.MessageLink;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.parser.internal.r;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class l implements Function1<f5b.b, f5b.b> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f414435c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Map<String, UrlCardPreviewEntity>> f414436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Map<String, MessageLink>> f414437b;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.model.operation.l$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C4838a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f414438a = null;

            static {
                int[] r100 = new int[Message.Type.values().length];
                r100[Message.Type.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[Message.Type.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[Message.Type.FILE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f414438a = r100;
            }
        }

        @JvmStatic
        public static void a(Message r100, Map r101) {
            Intrinsics.checkNotNullParameter(r100, "message");
            Message.Type r102 = r100.getType();
            if (r102 != null) goto L5;
            int r103 = -1;
        L7:
            if (r103 != 1) goto L9;
            TextContent r104 = (TextContent) r100.getContent();
            b(r104.getPreviewHangPoints(), r101);
            r.x(r104.getRichText(), r104.getPreviewHangPoints());
            return;
        L9:
            if (r103 != 2) goto L11;
            PostContent r105 = (PostContent) r100.getContent();
            b(r105.getPreviewHangPoints(), r101);
            r.x(r105.getRichText(), r105.getPreviewHangPoints());
            return;
        L11:
            if (r103 != 3) goto L19;
            b(((FileContent) r100.getContent()).getPreviewHangPoints(), r101);
            return;
        L19:
            return;
        L5:
            r103 = C4838a.f414438a[r102.ordinal()];
            goto L7
        }

        @JvmStatic
        public static void b(Map r100, Map r101) {
            Intrinsics.checkNotNullParameter(r100, "hangPoints");
            Iterator r102 = r100.entrySet().iterator();
        L4:
            if (r102.hasNext() == false) goto L18;
            Map.Entry r103 = (Map.Entry) r102.next();
            String r104 = ((PreviewHangPoint) r103.getValue()).getPreviewId();
            if (r104 == null) goto L4;
            if (r101 == null) goto L10;
            UrlCardPreviewEntity r105 = (UrlCardPreviewEntity) r101.get(r104);
        L11:
            PreviewHangPoint r106 = (PreviewHangPoint) r103.getValue();
            if (r106.getUrlCardPreviewEntity() == null) goto L13;
            if (r105 == null) goto L4;
            UrlCardPreviewEntity r107 = r106.getUrlCardPreviewEntity();
            Intrinsics.checkNotNull(r107);
            if (r105.compareTo2(r107) < 0) goto L4;
            r106.setUrlCardPreviewEntity(r105);
            goto L4
        L13:
            r106.setUrlCardPreviewEntity(r105);
            goto L4
        L10:
            r105 = null;
            goto L11
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f414439a = null;

        static {
            int[] r100 = new int[Message.Type.values().length];
            r100[Message.Type.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[Message.Type.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[Message.Type.FILE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f414439a = r100;
        }
    }

    static {
    }

    @Override // kotlin.jvm.functions.Function1
    public final f5b.b invoke(f5b.b r110) {
        f5b.b r111 = r110;
        Map<String, MessageLink> r100 = null;
        if (r111 == null) goto L79;
        final f5b.b r112 = r111.clone();
        Map<String, Map<String, UrlCardPreviewEntity>> r101 = this.f414436a;
        if (r101 == null) goto L59;
        Map<String, UrlCardPreviewEntity> r102 = r101.get(r112.getId());
        Message r103 = r112.getMessage();
        Message r104 = r112.getMessage();
        Message.Type r105 = r104.getType();
        if (r105 != null) goto L11;
        int r106 = -1;
    L13:
        if (r106 != 1) goto L15;
    L20:
        Map<String, PreviewHangPoint> r107 = ((BaseTextContent) r104.getContent()).getPreviewHangPoints();
    L21:
        if (r107 == null) goto L47;
        LinkedHashMap r108 = new LinkedHashMap();
        Iterator<Map.Entry<String, PreviewHangPoint>> r109 = r107.entrySet().iterator();
    L24:
        if (r109.hasNext() == false) goto L28;
        Map.Entry<String, PreviewHangPoint> r113 = r109.next();
        String r114 = r113.getValue().getPreviewId();
        if (r114 == null) goto L24;
        r108.put(r114, r113.getValue());
        goto L24
    L28:
        boolean r115 = false;
        if (r102 == null) goto L46;
        Iterator<Map.Entry<String, UrlCardPreviewEntity>> r116 = r102.entrySet().iterator();
    L32:
        if (r116.hasNext() == false) goto L46;
        Map.Entry<String, UrlCardPreviewEntity> r117 = r116.next();
        String r118 = r117.getKey();
        UrlCardPreviewEntity r119 = r117.getValue();
        LinkedHashMap r120 = new LinkedHashMap();
        Iterator r121 = r108.entrySet().iterator();
    L35:
        if (r121.hasNext() == false) goto L39;
        Map.Entry r122 = (Map.Entry) r121.next();
        if (Intrinsics.areEqual(((PreviewHangPoint) r122.getValue()).getPreviewId(), r118) == false) goto L35;
        r120.put(r122.getKey(), r122.getValue());
        goto L35
    L39:
        PreviewHangPoint r123 = (PreviewHangPoint) r120.get(r118);
        if (r123 == null) goto L32;
        if (r123.getUrlCardPreviewEntity() == null) goto L45;
        if (r119.isContentSame(r123.getUrlCardPreviewEntity()) == true) goto L32;
    L45:
        r115 = true;
    L46:
        r112.setForceUpdate(r115);
    L47:
        a.a(r103, r102);
        LinkedHashMap<String, MessageLink> r124 = r103.getMessageLinkMap();
        Map<String, Map<String, MessageLink>> r125 = this.f414437b;
        if (r125 == null) goto L50;
        r100 = r125.get(r103.getId());
    L50:
        if (r100 == null) goto L56;
        Iterator<Map.Entry<String, MessageLink>> r126 = r100.entrySet().iterator();
    L53:
        if (r126.hasNext() == false) goto L56;
        Map.Entry<String, MessageLink> r127 = r126.next();
        Intrinsics.checkNotNull(r124);
        r124.put(r127.getKey(), r127.getValue());
    L56:
        if (Message.Type.MERGE_FORWARD != r112.getMessage().getType()) goto L59;
        r112.setForceUpdate(m.a(r112, new PreviewUpdater$invoke$isForceUpdate$1(this, r112)));
        goto L59
    L15:
        if (r106 == 2) goto L20;
        if (r106 == 3) goto L19;
        r107 = null;
        goto L21
    L19:
        r107 = ((FileContent) r104.getContent()).getPreviewHangPoints();
        goto L21
    L11:
        r106 = b.f414439a[r105.ordinal()];
    L59:
        return r112;
    L79:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(Map<String, ? extends Map<String, UrlCardPreviewEntity>> r100, Map<String, ? extends Map<String, MessageLink>> r101) {
        this.f414436a = r100;
        this.f414437b = r101;
    }
}
