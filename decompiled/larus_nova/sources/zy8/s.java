package zy8;

import com.larus.bmhome.chat.bean.ChatPageContext;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f573972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f573973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ChatPageContext f573974c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f573972a, r101.f573972a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f573973b, r101.f573973b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f573974c, r101.f573974c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f573972a.hashCode() * 31) + this.f573973b.hashCode()) * 31;
        ChatPageContext r101 = this.f573974c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "GallerySendEventExt(imgSendEventExt=" + this.f573972a + ", textSendEventExt=" + this.f573973b + ", chatPageContext=" + this.f573974c + ')';
    }

    public final Map<String, String> a() {
        Map r100 = MapsKt.createMapBuilder();
        String r101 = this.f573972a.f573951a;
        if (r101 == null) goto L5;
        String r102 = (String) r100.put("enter_method", r101);
    L5:
        String r103 = this.f573972a.f573952b;
        if (r103 == null) goto L8;
        String r104 = (String) r100.put("scene", r103);
    L8:
        String r105 = this.f573972a.f573953c;
        if (r105 == null) goto L11;
        String r106 = (String) r100.put(com.bytedance.android.ec.core.event.a.KEY_CONTENT_SOURCE, r105);
    L11:
        String r107 = this.f573972a.f573954d;
        if (r107 == null) goto L14;
        String r108 = (String) r100.put("content_source_entrance", r107);
    L14:
        String r109 = this.f573972a.f573955e;
        if (r109 == null) goto L18;
        r100.put("picture_source_message_id", r109);
    L18:
        return MapsKt.build(r100);
    }

    public final Map<String, String> b() {
        Map r100 = MapsKt.createMapBuilder();
        String r101 = this.f573973b.f573975a;
        if (r101 == null) goto L5;
        String r102 = (String) r100.put("enter_method", r101);
    L5:
        String r103 = this.f573973b.f573976b;
        if (r103 == null) goto L8;
        String r104 = (String) r100.put("scene", r103);
    L8:
        String r105 = this.f573973b.f573977c;
        if (r105 == null) goto L11;
        String r106 = (String) r100.put(com.bytedance.android.ec.core.event.a.KEY_CONTENT_SOURCE, r105);
    L11:
        String r107 = this.f573973b.f573978d;
        if (r107 == null) goto L14;
        String r108 = (String) r100.put("content_source_entrance", r107);
    L14:
        String r109 = this.f573973b.f573979e;
        if (r109 == null) goto L18;
        r100.put("picture_source_message_id", r109);
    L18:
        return MapsKt.build(r100);
    }

    public s(a r100, t r101, ChatPageContext r102) {
        Intrinsics.checkNotNullParameter(r100, "imgSendEventExt");
        Intrinsics.checkNotNullParameter(r101, "textSendEventExt");
        this.f573972a = r100;
        this.f573973b = r101;
        this.f573974c = r102;
    }
}
