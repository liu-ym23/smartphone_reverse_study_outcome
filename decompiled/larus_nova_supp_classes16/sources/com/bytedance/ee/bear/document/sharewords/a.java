package com.bytedance.ee.bear.document.sharewords;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.middleground.comment.export.bean.PermMember;
import com.bytedance.ee.bear.middleground.comment.export.bean.PermMemberBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.VisibilityBean;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import e0c.k;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements b {
    public final Function3<String, VisibilityBean, String, Flowable<Boolean>> a;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.sharewords.a$a, reason: collision with other inner class name */
    public static final class C0104a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function3<? super String, ? super VisibilityBean, ? super String, ? extends Flowable<Boolean>> r2) {
        Intrinsics.checkNotNullParameter(r2, "addForwardComment");
        this.a = r2;
    }

    @Override // com.bytedance.ee.bear.document.sharewords.b
    public final Flowable<Boolean> a(String r9, List<? extends ForwardTarget> r10, RichText r11) {
        Intrinsics.checkNotNullParameter(r9, "forwardId");
        Intrinsics.checkNotNullParameter(r10, "targets");
        if (r11 == null) goto L71;
        if (TextUtils.isEmpty(r11.getInnerText()) == true) goto L71;
        ArrayList r0 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L8:
        boolean r2 = true;
        int r3 = 0;
        if (r12.hasNext() == false) goto L18;
        Object r1 = r12.next();
        ForwardTarget r4 = (ForwardTarget) r1;
        if (r4.b() != 0) goto L13;
    L16:
        if (r2 == false) goto L8;
        r0.add(r1);
        goto L8
    L13:
        if (r4.b() == 1) goto L16;
        r2 = false;
        goto L16
    L18:
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r5 = r0.iterator();
    L19:
        String r6 = null;
        if (r5.hasNext() == false) goto L39;
        ForwardTarget r7 = (ForwardTarget) r5.next();
        PermMember r8 = new PermMember();
        if (r7.b() != 1) goto L26;
        Chatter r14 = r7.a();
        if (r14 == null) goto L34;
        r6 = r14.getId();
    L34:
        r8.setOwnerId(r6);
        if (r7.b() != 1) goto L37;
        int r16 = 0;
    L38:
        r8.setOwnerType(r16);
        r8.setPermission(1);
        r8.setShowName(r7.b);
        r8.setAvatarUrl(r7.c);
        r13.add(r8);
        goto L19
    L37:
        r16 = 2;
        goto L38
    L26:
        Chat r17 = r7.e;
        if (r17 != null) goto L29;
    L31:
        Chat r18 = null;
    L32:
        if (r18 == null) goto L34;
        r6 = r18.getId();
        goto L34
    L29:
        if ((r17 instanceof Chat) == false) goto L31;
        r18 = r17;
        goto L32
    L39:
        List r19 = CollectionsKt.toMutableList(r13);
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type java.util.ArrayList<com.bytedance.ee.bear.middleground.comment.export.bean.PermMember>");
        VisibilityBean r20 = new VisibilityBean(0, 1, null);
        r20.setType(1);
        PermMemberBean r21 = new PermMemberBean();
        r21.setAfter((ArrayList) r19);
        r20.setPermissionMembers(r21);
        SpannableStringBuilder r110 = new SpannableStringBuilder();
        int r22 = r11.getElements().getDictionary().size();
        Iterator r111 = r11.getElements().getDictionary().values().iterator();
    L41:
        if (r111.hasNext() == false) goto L69;
        Object r23 = r111.next();
        int r24 = r3 + 1;
        if (r3 >= 0) goto L45;
        CollectionsKt.throwIndexOverflow();
    L45:
        RichTextElement r26 = (RichTextElement) r23;
        if (r26.getTag() != RichTextElement.RichTextTag.TEXT) goto L51;
        if ((r26.getProperty() instanceof RichTextElement.TextProperty) == false) goto L51;
        r110.append(r26.getProperty().getContent());
    L67:
        r3 = r24;
    L51:
        if (r26.getTag() != RichTextElement.RichTextTag.AT) goto L56;
        if ((r26.getProperty() instanceof RichTextElement.AtProperty) == false) goto L56;
        RichTextElement.AtProperty r27 = r26.getProperty();
        r110.append("<at type=\"0\" href=\"\" token=\"" + r27.getUserId() + "\">" + r27.getAtContent() + "</at>");
    L56:
        if (r26.getTag() != RichTextElement.RichTextTag.PARAGRAPH) goto L63;
        if (TextUtils.isEmpty(r110) == true) goto L63;
        if (r3 == 0) goto L63;
        if (r3 == r22) goto L63;
        r110.append(DocViewModel.ENTER_CHAR);
    L63:
        if (r26.getTag() != RichTextElement.RichTextTag.ANCHOR) goto L67;
        if ((r26.getProperty() instanceof RichTextElement.AnchorProperty) == false) goto L67;
        RichTextElement.AnchorProperty r28 = r26.getProperty();
        BearUrl r29 = ((t45.c) k.a(LarkContext.getApplication(), t45.c.class)).Z(r28.getHref());
        r110.append("<at type=\"" + r29.a() + "\" href=\"" + r28.getHref() + "\" token=\"" + r29.b + "\" >" + r28.getDisplayTitle() + "</at>");
        goto L67
    L69:
        return (Flowable) this.a.invoke(r110.toString(), r20, r9);
    L71:
        return Flowable.just(Boolean.TRUE);
    }
}
