package com.ss.android.lark.keyboard.edittext2.edittors;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import com.ss.android.lark.widget.span.AtUserGroupInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public class b extends BaseFunctionEditor<hob.d> implements com.ss.android.lark.keyboard.edittext2.base.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f429044d = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C5091b f429045c;

    public static final class a implements com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC5085a<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.keyboard.edittext2.base.d f429046a;

        @Override // com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC5085a
        public final Class<b> a() {
            return this.f429046a.f428961a;
        }

        public a() {
            this.f429046a = new com.ss.android.lark.keyboard.edittext2.base.d(b.class);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.edittext2.edittors.b$b, reason: collision with other inner class name */
    public static final class C5091b {
        public C5091b() {
        }
    }

    static {
        f429044d = new a();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor, com.ss.android.lark.keyboard.edittext2.base.a
    public final void d() {
    }

    public b() {
        this.f429045c = new C5091b();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public /* bridge */ /* synthetic */ void S(SpannableStringBuilder r100, hob.d r101, int r102) {
        U(r100, r101, r102);
    }

    public void U(SpannableStringBuilder r100, hob.d r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r110, "data");
        Context r101 = context();
        String r102 = "@" + r110.f486320b;
        boolean r103 = true;
        if (r110.f486321c == 1) goto L6;
        r103 = false;
    L6:
        r100.append(r102);
        if (r103 == false) goto L10;
        int r104 = UIUtils.getColor(r101, R.color.imtoken_message_text_bubbles_blue);
        C5091b r105 = this.f429045c;
        AtUserGroupInfo r106 = new AtUserGroupInfo(r110.f486319a, r110.f486320b, r110.f486321c);
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "spanInfo");
        r100.setSpan(new com.ss.android.lark.widget.light.span.c(r106, r104), r111, r102.length() + r111, 33);
        r100.setSpan(new com.ss.android.lark.keyboard.edittext2.span.b(), r111, r102.length() + r111, 33);
    L10:
        if (r110.f486322d == false) goto L12;
        r100.append(" ");
    L12:
        int r107 = com.ss.android.lark.keyboard.edittext2.utils.e.c(com.ss.android.lark.keyboard.edittext2.base.c.a.a(this));
        if (r107 < 0) goto L16;
        com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getEditableText().delete(r107, r107 + 1);
        return;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final void T(hob.d r100, SpannableStringBuilder r101, int r102, int r103) {
        hob.d r104 = r100;
        Intrinsics.checkNotNullParameter(r104, "data");
        Intrinsics.checkNotNullParameter(r101, "text");
        long r105 = r104.f486319a;
        String r106 = r104.f486320b;
        int r107 = r104.f486321c;
        Map<Class<? extends RichTextElement.RichTextProperty>, RichTextElement.RichTextTag> r108 = RichTextElementCreator.f448209a;
        Intrinsics.checkNotNullParameter(r106, "userGroupName");
        Intrinsics.checkNotNullParameter(r106, "userGroupName");
        RichTextElement.AtUserGroupProperty r109 = new RichTextElement.AtUserGroupProperty();
        r109.setUserGroupId(r105);
        r109.setDisplayName(r106);
        r109.setDefaultGroupName(r106);
        r109.setPermissionStatus(r107);
        RichTextElement r110 = RichTextElementCreator.h(r109);
        if (r104.f486322d == true) goto L5;
    L7:
        r101.setSpan(new p(r110, r101.subSequence(r102, r103).toString()), r102, r103, 33);
        r101.setSpan(new gob.a(), r102, r103, 33);
        return;
    L5:
        if (StringsKt.endsWith$default(r101, " ", false, 2, null) == false) goto L7;
        r103 = r103 - 1;
        goto L7
    }
}
