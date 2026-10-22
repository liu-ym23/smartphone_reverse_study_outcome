package com.larus.bmhome.chat.component.regen;

import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f301444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f301445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f301446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f301447d;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f301444a, r101.f301444a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f301445b, r101.f301445b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f301446c, r101.f301446c) == true) goto L18;
        return false;
    L18:
        if (this.f301447d == r101.f301447d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f301444a.hashCode() * 31) + this.f301445b.hashCode()) * 31) + this.f301446c.hashCode()) * 31;
        if (this.f301447d == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "RegenAnswersData(question=" + this.f301444a + ", selected=" + this.f301445b + ", answers=" + this.f301446c + ", noRegenAction=" + this.f301447d + ')';
    }

    public final boolean a(Message r110) {
        Integer r100 = null;
        int r101 = -1;
        boolean r102 = false;
        if (b(r110) == true) goto L5;
    L25:
        boolean r103 = false;
    L26:
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("isRegenerate result=");
        r105.append(r103);
        r105.append(" messageId=");
        if (r110 == null) goto L29;
        String r111 = r110.getMessageId();
    L30:
        r105.append(r111);
        r105.append(" preIndex=");
        if (this.f301445b.length() != 0) goto L33;
        boolean r112 = true;
    L34:
        if (r112 == false) goto L36;
        int r113 = -1;
    L37:
        Integer r114 = Integer.valueOf(r113);
        int r106 = r114.intValue();
        if (r106 > 0) goto L40;
    L42:
        if (r102 == false) goto L44;
        r100 = r114;
    L44:
        if (r100 == null) goto L46;
        r101 = r100.intValue() - 1;
    L46:
        r105.append(r101);
        r104.i("RegenAnswersData", r105.toString());
        return r103;
    L40:
        if (r106 >= this.f301446c.size()) goto L42;
        r102 = true;
        goto L42
    L36:
        r113 = this.f301446c.indexOf(this.f301445b);
        goto L37
    L33:
        r112 = false;
        goto L34
    L29:
        r111 = null;
        goto L30
    L5:
        if (this.f301445b.length() != 0) goto L7;
        boolean r107 = true;
    L8:
        if (r107 == false) goto L10;
        int r108 = -1;
    L11:
        Integer r109 = Integer.valueOf(r108);
        int r115 = r109.intValue();
        if (r115 > 0) goto L14;
    L16:
        boolean r116 = false;
    L17:
        if (r116 == true) goto L20;
        r109 = null;
    L20:
        if (r109 == null) goto L22;
        int r117 = r109.intValue() - 1;
    L23:
        if (r117 < 0) goto L25;
        r103 = true;
        goto L26
    L22:
        r117 = -1;
        goto L23
    L14:
        if (r115 >= this.f301446c.size()) goto L16;
        r116 = true;
        goto L17
    L10:
        r108 = this.f301446c.indexOf(this.f301445b);
        goto L11
    L7:
        r107 = false;
        goto L8
    }

    public final boolean b(Message r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        Integer r103 = null;
        if (r102 == true) goto L23;
        if (r100 != null) goto L12;
    L14:
        boolean r104 = false;
    L15:
        if (r104 == true) goto L23;
        if (r100 != null) goto L18;
    L20:
        boolean r105 = false;
    L21:
        if (r105 == true) goto L23;
    L31:
        if ((!this.f301446c.isEmpty()) == true) goto L32;
    L29:
        r101 = false;
    L43:
        FLogger r106 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder("isRegenerateValid result=");
        r107.append(r101);
        r107.append(" question=");
        r107.append(this.f301444a);
        r107.append(" replyId=");
        if (r100 == null) goto L46;
        String r108 = r100.getReplyId();
    L47:
        r107.append(r108);
        r107.append(" msgId=");
        if (r100 == null) goto L50;
        String r109 = r100.getMessageId();
    L51:
        r107.append(r109);
        r107.append(" localMsgId=");
        if (r100 == null) goto L54;
        String r110 = r100.getLocalMessageId();
    L55:
        r107.append(r110);
        r107.append(" contentType=");
        if (r100 == null) goto L58;
        r103 = Integer.valueOf(r100.getContentType());
    L58:
        r107.append(r103);
        r107.append(" answersSize=");
        r107.append(this.f301446c.size());
        r107.append(" selected=");
        r107.append(this.f301445b);
        r107.append(" noRegenAction=");
        r107.append(this.f301447d);
        r106.i("RegenAnswersData", r107.toString());
        return r101;
    L54:
        r110 = null;
        goto L55
    L50:
        r109 = null;
        goto L51
    L46:
        r108 = null;
        goto L47
    L32:
        if (r100 == null) goto L34;
        String r111 = r100.getReplyId();
    L36:
        if (o0.d(r111) == false) goto L29;
        String r112 = this.f301444a;
        if (r100 == null) goto L40;
        String r113 = r100.getReplyId();
    L42:
        if (Intrinsics.areEqual(r112, r113) == false) goto L29;
    L40:
        r113 = null;
        goto L42
    L34:
        r111 = null;
        goto L36
    L18:
        if (i.b(r100) != true) goto L20;
        r105 = true;
        goto L21
    L12:
        if (i.a(r100) != true) goto L14;
        r104 = true;
    L23:
        if (r100.getUserType() != 2) goto L31;
        if (o0.d(r100.getReplyId()) == false) goto L29;
        if (Intrinsics.areEqual(this.f301444a, r100.getReplyId()) == false) goto L29;
    L5:
        if (r100.getContentType() != 6) goto L7;
        r102 = true;
        goto L8
    }

    public h(String r100, String r101, List<String> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.VALUE_QUESTION);
        Intrinsics.checkNotNullParameter(r101, "selected");
        Intrinsics.checkNotNullParameter(r102, "answers");
        this.f301444a = r100;
        this.f301445b = r101;
        this.f301446c = r102;
        this.f301447d = r103;
    }
}
