package com.obric.assistant.chat.component.bottom.core.mention;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import androidx.core.content.ContextCompat;
import com.larus.applog.api.IApplog;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.p1;
import com.larus.bmhome.chat.model.j1;
import com.larus.bmhome.view.ChatInputText;
import com.larus.nova.R;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ability.chat.input.SkillSelectSource;
import com.obric.assistant.chat.component.bottom.core.k;
import com.obric.assistant.special_input.PhoneOperationModeRestoreResult;
import com.obric.assistant.special_input.j;
import com.obric.assistant.special_input.p0;
import com.obric.assistant.util.ObricMentionHighlightHelper;
import com.obric.assistant.util.r1;
import com.obric.assistant.util.s1;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class ObricMentionInputController {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f386757o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f386758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EditText f386759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final paa.c f386760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p1 f386761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.larus.bmhome.instruction.g f386762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ICoreInputAbility f386763f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<de8.c> f386764g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ObricMentionHighlightHelper.a f386765h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f386766i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f386767j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f386768k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final f f386769l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final g f386770m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final h f386771n;

    public static final class a {
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final paa.e f386772a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f386772a, ((a) r100).f386772a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f386772a.hashCode();
            }

            public final String toString() {
                return "Allowed(skill=" + this.f386772a + ')';
            }

            public a(paa.e r100) {
                Intrinsics.checkNotNullParameter(r100, SlashMentionConfig.SLASH_CONTENT_SKILL);
                this.f386772a = r100;
            }
        }

        /* JADX INFO: renamed from: com.obric.assistant.chat.component.bottom.core.mention.ObricMentionInputController$b$b, reason: collision with other inner class name */
        public static final class C4596b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f386773a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C4596b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f386773a, ((C4596b) r100).f386773a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f386773a.hashCode();
            }

            public final String toString() {
                return "Rejected(reason=" + this.f386773a + ')';
            }

            public C4596b(String r100) {
                Intrinsics.checkNotNullParameter(r100, "reason");
                this.f386773a = r100;
            }
        }

        public b() {
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f386774a = null;

        static {
            int[] r100 = new int[PhoneOperationModeRestoreResult.values().length];
            r100[PhoneOperationModeRestoreResult.READY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[PhoneOperationModeRestoreResult.NOT_READY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[PhoneOperationModeRestoreResult.UNAVAILABLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f386774a = r100;
        }
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.obric.assistant.chat.component.bottom.core.mention.b, java.lang.Object] */
    public final void b() {
        if (this.f386765h == null) goto L5;
        return;
    L5:
        int r100 = ContextCompat.getColor(this.f386758a, R.color.obric_custom_action_bar_blue_icon_and_text_color);
        int r101 = ObricMentionHighlightHelper.f393597a;
        EditText r102 = this.f386759b;
        ObricMentionInputController$attachHighlight$1 r103 = new ObricMentionInputController$attachHighlight$1(this);
        ?? r104 = new com.obric.assistant.chat.component.bottom.core.mention.b(this);
        ObricMentionInputController$attachHighlight$3 r105 = new ObricMentionInputController$attachHighlight$3(this);
        ObricMentionInputController$attachHighlight$4 r106 = new ObricMentionInputController$attachHighlight$4(this);
        Intrinsics.checkNotNullParameter(r102, "editText");
        Intrinsics.checkNotNullParameter(r103, "isEnabled");
        Intrinsics.checkNotNullParameter(r104, "mentionItemsProvider");
        Intrinsics.checkNotNullParameter(r105, "onSelected");
        Intrinsics.checkNotNullParameter(r106, "onUnselected");
        final ObricMentionHighlightHelper.a r107 = new ObricMentionHighlightHelper.a(r102, r100, r103, r104, r105, r106);
        Object r108 = r107.f393599a.getTag(R.id.obric_mention_origin_key_listener);
        ChatInputText r109 = null;
        if ((r108 instanceof View.OnKeyListener) == false) goto L8;
        View.OnKeyListener r110 = (View.OnKeyListener) r108;
    L9:
        r107.f393611m = r110;
        r107.f393599a.setOnKeyListener(new r1(r107));
        EditText r111 = r107.f393599a;
        if ((r111 instanceof ChatInputText) == false) goto L12;
        r109 = (ChatInputText) r111;
    L12:
        if (r109 == null) goto L16;
        s1 r112 = r107.f393614p;
        Intrinsics.checkNotNullParameter(r112, "interceptor");
        if (((ArrayList) r109.f315419f).contains(r112) == true) goto L16;
        ((ArrayList) r109.f315419f).add(r112);
    L16:
        r107.g(r107.f393599a.getText());
        r107.f393599a.addTextChangedListener(r107);
        r107.o(r107.f393599a.getText());
        this.f386765h = r107;
        return;
    L8:
        r110 = null;
        goto L9
    }

    public final void d() {
        if (this.f386768k == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L10;
        this.f386759b.post(new com.obric.assistant.chat.component.bottom.core.mention.c(this));
        return;
    L10:
        if (this.f386767j == true) goto L13;
        FLogger.f375446a.i("ObricMentionInputController", "consumeAutoMentionFromRoute: wait for text draft restore");
        return;
    L13:
        de8.c r100 = this.f386764g.invoke();
        List<paa.e> r101 = null;
        if (r100 == null) goto L17;
        Bundle r102 = r100.f468086b;
        if (r102 == null) goto L17;
    L21:
        if (com.obric.assistant.chat.b.b(r102) == true) goto L23;
        return;
    L23:
        boolean r103 = false;
        if (com.obric.assistant.chat.b.c(r102) == false) goto L69;
        b r104 = k(r102);
        if ((r104 instanceof b.a) == false) goto L64;
        paa.e r105 = ((b.a) r104).f386772a;
        if (r102 == null) goto L30;
        String r110 = r102.getString("obric_auto_mention_content");
    L31:
        if (r110 != null) goto L34;
        r110 = "";
    L34:
        if (StringsKt.isBlank(r110) == false) goto L36;
        j(r102, "route_demo", "content_blank");
        e();
        return;
    L36:
        String r111 = "@" + r105.f528397b;
        if (StringsKt.contains$default(r110, r111, false, 2, null) == true) goto L40;
        r110 = r111 + ' ' + r110;
    L40:
        paa.c r106 = this.f386760c;
        if (r106 == null) goto L43;
        r101 = r106.Nh();
    L43:
        if (r101 != null) goto L45;
        r101 = CollectionsKt.emptyList();
    L45:
        List r107 = CollectionsKt.plus(r101, r105);
        HashSet r108 = new HashSet();
        ArrayList r112 = new ArrayList();
        Iterator r109 = r107.iterator();
    L47:
        if (r109.hasNext() == false) goto L51;
        Object r113 = r109.next();
        if (r108.add(((paa.e) r113).f528396a) == false) goto L47;
        r112.add(r113);
        goto L47
    L51:
        int r114 = ObricMentionHighlightHelper.f393597a;
        ObricMentionHighlightHelper.d r115 = ObricMentionHighlightHelper.a(r110, ContextCompat.getColor(this.f386758a, R.color.obric_custom_action_bar_blue_icon_and_text_color), r112);
        if (r115 != null) goto L54;
        j(r102, "route_demo", "restore_content_empty");
        e();
        return;
    L54:
        PhoneOperationModeRestoreResult r116 = p0.a(this.f386762e, "route_demo", true);
        Intrinsics.checkNotNullParameter(r116, "<this>");
        if (r116 != PhoneOperationModeRestoreResult.READY) goto L57;
        r103 = true;
    L57:
        if (r103 == true) goto L60;
        j(r102, "route_demo", "phone_operation_unavailable");
        e();
        return;
    L60:
        if (o(r105, r115.f393624b, SkillSelectSource.ROUTE_DEMO, true) == true) goto L62;
        FLogger.f375446a.w("ObricMentionInputController", "consumeAutoMentionPrefillFromRoute: sync failed, skillId=" + r105.f528396a);
        j(r102, "route_demo", "sync_failed");
        e();
        return;
    L62:
        a(r105, "obric_auto_mention_prefill", r115.f393623a, true);
        e();
        FLogger.f375446a.i("ObricMentionInputController", "consumeAutoMentionPrefillFromRoute: success, skillId=" + r105.f528396a);
        return;
    L30:
        r110 = null;
        goto L31
    L64:
        if ((r104 instanceof b.C4596b) == false) goto L68;
        FLogger r117 = FLogger.f375446a;
        StringBuilder r118 = new StringBuilder("consumeAutoMentionPrefillFromRoute: rejected, reason=");
        b.C4596b r119 = (b.C4596b) r104;
        r118.append(r119.f386773a);
        r117.w("ObricMentionInputController", r118.toString());
        j(r102, "route_demo", r119.f386773a);
        e();
        return;
    L68:
        throw new NoWhenBranchMatchedException();
    L69:
        b r120 = k(r102);
        if ((r120 instanceof b.a) == false) goto L91;
        paa.e r121 = ((b.a) r120).f386772a;
        PhoneOperationModeRestoreResult r122 = p0.a(this.f386762e, "route_use", true);
        Intrinsics.checkNotNullParameter(r122, "<this>");
        if (r122 != PhoneOperationModeRestoreResult.READY) goto L74;
        boolean r123 = true;
    L75:
        if (r123 == true) goto L78;
        j(r102, "route_use", "phone_operation_unavailable");
        e();
        return;
    L78:
        List<String> r124 = CollectionsKt.listOf(r121.f528396a);
        SkillSelectSource r125 = SkillSelectSource.ROUTE_USE;
        ICoreInputAbility r126 = this.f386763f;
        if (r126 != null) goto L81;
    L83:
        boolean r127 = false;
    L85:
        if (o(r121, r124, r125, true ^ r127) == true) goto L88;
        FLogger.f375446a.w("ObricMentionInputController", "consumeAutoMentionFromRoute: sync failed, skillId=" + r121.f528396a);
        j(r102, "route_use", "sync_failed");
        e();
        return;
    L88:
        a(r121, "obric_auto_mention", null, false);
        e();
        return;
    L81:
        if (r126.Rp() != 2) goto L83;
        r127 = true;
        goto L85
    L74:
        r123 = false;
        goto L75
    L91:
        if ((r120 instanceof b.C4596b) == false) goto L95;
        FLogger r128 = FLogger.f375446a;
        StringBuilder r129 = new StringBuilder("consumeAutoMentionFromRoute: rejected, reason=");
        b.C4596b r130 = (b.C4596b) r120;
        r129.append(r130.f386773a);
        r128.w("ObricMentionInputController", r129.toString());
        j(r102, "route_use", r130.f386773a);
        e();
        return;
    L95:
        throw new NoWhenBranchMatchedException();
    L17:
        if (r100 == null) goto L19;
        r102 = r100.f468085a;
        goto L21
    L19:
        r102 = null;
        goto L21
    }

    public final void e() {
        de8.c r100 = this.f386764g.invoke();
        int r101 = com.obric.assistant.chat.b.f386642a;
        Bundle r102 = null;
        if (r100 == null) goto L5;
        Bundle r103 = r100.f468086b;
    L6:
        com.obric.assistant.chat.b.a(r103);
        if (r100 == null) goto L9;
        r102 = r100.f468085a;
    L9:
        com.obric.assistant.chat.b.a(r102);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void f() {
        paa.c r100 = this.f386760c;
        if (r100 == null) goto L5;
        List<paa.e> r101 = r100.a00();
    L6:
        if (r101 != null) goto L8;
        r101 = CollectionsKt.emptyList();
    L8:
        Iterator<T> r102 = r101.iterator();
    L10:
        if (r102.hasNext() == false) goto L14;
        paa.e r103 = (paa.e) r102.next();
        b();
        ObricMentionHighlightHelper.a r104 = this.f386765h;
        if (r104 == null) goto L10;
        r104.l(r103);
        goto L10
    L14:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void g() {
        p1 r100 = this.f386761d;
        if (r100 == null) goto L18;
        j1 r101 = r100.Y3();
        if (r101 == null) goto L19;
        paa.c r102 = this.f386760c;
        if (r102 == null) goto L10;
        List<String> r103 = r102.Yg();
    L11:
        if (r103 != null) goto L14;
        r103 = CollectionsKt.emptyList();
    L14:
        if (Intrinsics.areEqual(r101.o(), r103) == false) goto L16;
        return;
    L16:
        r101.k(r103);
        return;
    L10:
        r103 = null;
        goto L11
    L19:
        return;
    }

    public final void h() {
        p1 r100 = this.f386761d;
        if (r100 == null) goto L18;
        j1 r101 = r100.Y3();
        if (r101 == null) goto L19;
        paa.c r102 = this.f386760c;
        if (r102 == null) goto L10;
        List<String> r103 = r102.AM();
    L11:
        if (r103 != null) goto L14;
        r103 = CollectionsKt.emptyList();
    L14:
        if (Intrinsics.areEqual(r101.r(), r103) == false) goto L16;
        return;
    L16:
        r101.j(r103);
        return;
    L10:
        r103 = null;
        goto L11
    L19:
        return;
    }

    public final void i() {
        if (this.f386768k == true) goto L5;
        return;
    L5:
        ICoreInputAbility r100 = this.f386763f;
        if (r100 == null) goto L9;
        r100.oz(com.obric.assistant.task.skill.f.d());
    L9:
        if (com.obric.assistant.task.skill.f.d() == true) goto L11;
    L13:
        boolean r101 = false;
    L14:
        if (r101 == true) goto L19;
        ObricMentionHighlightHelper.a r102 = this.f386765h;
        if (r102 == null) goto L20;
        r102.f393606h = null;
        r102.e();
        return;
    L20:
        return;
    L19:
        return;
    L11:
        if (j.b() == false) goto L13;
        r101 = true;
        goto L14
    }

    public final b k(Bundle r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getString("obric_skill_slug");
        String r102 = "";
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        String r103 = StringsKt.trim(r101).toString();
        String r104 = r100.getString("obric_skill_display_name");
        if (r104 == null) goto L12;
        r102 = r104;
    L12:
        String r105 = StringsKt.trim(r102).toString();
        if (StringsKt.isBlank(r103) == true) goto L36;
        if (StringsKt.isBlank(r105) == true) goto L36;
        paa.c r106 = this.f386760c;
        if (r106 == null) goto L20;
        paa.e r107 = r106.GJ(r103);
        if (r107 != null) goto L24;
        String r108 = r100.getString("obric_skill_cover_url");
        if (r108 == null) goto L32;
        String r109 = StringsKt.trim(r108).toString();
        if (r109 == null) goto L32;
        if ((!StringsKt.isBlank(r109)) == false) goto L32;
    L34:
        return new b.a(new paa.e(r103, r105, r109, 56));
    L32:
        r109 = null;
        goto L34
    L24:
        return new b.a(r107);
    L20:
        return new b.C4596b("skill ability unavailable");
    L36:
        return new b.C4596b("skill metadata is blank");
    L4:
        return new b.C4596b("arguments is null");
    }

    public final void l(List<paa.e> r110) {
        if (this.f386767j == true) goto L5;
        return;
    L5:
        p1 r100 = this.f386761d;
        if (r100 == null) goto L80;
        j1 r101 = r100.Y3();
        if (r101 == null) goto L82;
        List<String> r102 = r101.r();
        if (r102.isEmpty() == false) goto L13;
        return;
    L13:
        boolean r103 = false;
        if (r110.isEmpty() == false) goto L23;
        paa.c r104 = this.f386760c;
        if (r104 != null) goto L18;
    L20:
        boolean r105 = false;
    L21:
        if (r105 == true) goto L23;
        return;
    L18:
        if (r104.Yb() != true) goto L20;
        r105 = true;
    L23:
        HashSet r106 = new HashSet();
        Iterator<T> r111 = r110.iterator();
    L25:
        if (r111.hasNext() == false) goto L27;
        r106.add(((paa.e) r111.next()).f528396a);
        goto L25
    L27:
        ArrayList r107 = new ArrayList();
        Iterator<T> r112 = r102.iterator();
    L29:
        if (r112.hasNext() == false) goto L34;
        Object r108 = r112.next();
        if (r106.contains((String) r108) == false) goto L29;
        r107.add(r108);
        goto L29
    L34:
        if (r107.isEmpty() == false) goto L40;
        FLogger.f375446a.i("ObricMentionInputController", "restoreSelectedSkillsFromDraft: no available skill matches draft, clear draft");
        paa.c r113 = this.f386760c;
        if (r113 == null) goto L38;
        r113.x70(CollectionsKt.emptyList());
    L38:
        r101.j(CollectionsKt.emptyList());
        return;
    L40:
        paa.c r114 = this.f386760c;
        if (r114 == null) goto L43;
        List<String> r115 = r114.AM();
    L44:
        if (r115 != null) goto L47;
        r115 = CollectionsKt.emptyList();
    L47:
        if (Intrinsics.areEqual(CollectionsKt.toSet(r115), CollectionsKt.toSet(r107)) == false) goto L49;
        return;
    L49:
        int r116 = c.f386774a[p0.a(this.f386762e, "selected_draft_restore", true).ordinal()];
        if (r116 == 1) goto L63;
        if (r116 != 2) goto L53;
        FLogger.f375446a.i("ObricMentionInputController", "restoreSelectedSkillsFromDraft: wait omni skill state");
        return;
    L53:
        if (r116 != 3) goto L60;
        FLogger.f375446a.w("ObricMentionInputController", "restoreSelectedSkillsFromDraft: phone-operation/omni unavailable, clear draft");
        paa.c r117 = this.f386760c;
        if (r117 == null) goto L57;
        r117.x70(CollectionsKt.emptyList());
    L57:
        r101.j(CollectionsKt.emptyList());
        return;
    L60:
        throw new NoWhenBranchMatchedException();
    L63:
        paa.c r118 = this.f386760c;
        if (r118 == null) goto L66;
        r118.x70(r107);
    L66:
        h();
        FLogger.f375446a.i("ObricMentionInputController", "restoreSelectedSkillsFromDraft: restored skillIds=" + CollectionsKt.joinToString$default(r107, null, null, null, 0, null, null, 63, null));
        ICoreInputAbility r119 = this.f386763f;
        if (r119 != null) goto L69;
    L71:
        if (r103 == true) goto L81;
        f();
        return;
    L81:
        return;
    L69:
        if (r119.Rp() != 2) goto L71;
        r103 = true;
        goto L71
    L43:
        r115 = null;
        goto L44
    L82:
        return;
    }

    public final void m(List<paa.e> r110) {
        String r100 = this.f386766i;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r110.isEmpty() == false) goto L8;
        return;
    L8:
        Editable r101 = this.f386759b.getText();
        if (r101 == null) goto L26;
        String r102 = r101.toString();
        if (r102 != null) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(r102, r100) == true) goto L17;
        this.f386766i = null;
        FLogger.f375446a.i("ObricMentionInputController", "retryDraftRestoreIfNeeded skipped, input text changed");
        return;
    L17:
        CharSequence r103 = c(r100, r110, false);
        if (r103 != null) goto L21;
        FLogger.f375446a.i("ObricMentionInputController", "retryDraftRestoreIfNeeded skipped, no mention match");
        return;
    L21:
        ICoreInputAbility r104 = this.f386763f;
        if (r104 == null) goto L24;
        ICoreInputAbility.b.d(r104, r103, false, false, null, null, false, 62);
    L24:
        FLogger.f375446a.i("ObricMentionInputController", "retryDraftRestoreIfNeeded success");
        return;
    }

    public final void n(List<String> r100, SkillSelectSource r101) {
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        String r103 = (String) r102.next();
        paa.c r104 = this.f386760c;
        if (r104 == null) goto L4;
        r104.YW(r103, r101);
        goto L4
    L8:
        g();
    }

    public final CharSequence c(String r100, List<paa.e> r101, boolean r110) {
        p1 r102 = this.f386761d;
        if (r102 == null) goto L7;
        j1 r103 = r102.Y3();
        if (r103 == null) goto L7;
        List<String> r104 = r103.o();
    L8:
        if (r104 != null) goto L11;
        r104 = CollectionsKt.emptyList();
    L11:
        if (r104.isEmpty() == false) goto L13;
        return null;
    L13:
        int r105 = ContextCompat.getColor(this.f386758a, R.color.obric_custom_action_bar_blue_icon_and_text_color);
        Set r106 = CollectionsKt.toSet(r104);
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r101.iterator();
    L15:
        if (r108.hasNext() == false) goto L19;
        Object r109 = r108.next();
        if (r106.contains(((paa.e) r109).f528396a) == false) goto L15;
        r107.add(r109);
        goto L15
    L19:
        ObricMentionHighlightHelper.d r111 = ObricMentionHighlightHelper.a(r100, r105, r107);
        if (r111 != null) goto L28;
        if (r110 == true) goto L23;
    L27:
        return null;
    L23:
        if (r101.isEmpty() == false) goto L27;
        if (StringsKt.contains$default(r100, '@', false, 2, null) == false) goto L27;
        this.f386766i = r100;
        FLogger.f375446a.i("ObricMentionInputController", "buildRestoreTextDraftContent: defer until skill cache loaded");
        goto L27
    L28:
        int r112 = c.f386774a[p0.a(this.f386762e, "draft_restore", true).ordinal()];
        if (r112 == 1) goto L43;
        if (r112 != 2) goto L32;
        this.f386766i = r100;
        FLogger.f375446a.i("ObricMentionInputController", "buildRestoreTextDraftContent: defer until omni skill state ready");
        return null;
    L32:
        if (r112 != 3) goto L40;
        this.f386766i = null;
        FLogger.f375446a.w("ObricMentionInputController", "buildRestoreTextDraftContent: skip mention restore, phone operation mode unavailable");
        p1 r113 = this.f386761d;
        if (r113 == null) goto L38;
        j1 r114 = r113.Y3();
        if (r114 == null) goto L38;
        r114.k(CollectionsKt.emptyList());
    L38:
        return null;
    L40:
        throw new NoWhenBranchMatchedException();
    L43:
        this.f386766i = null;
        n(r111.f393624b, SkillSelectSource.DRAFT);
        return r111.f393623a;
    L7:
        r104 = null;
        goto L8
    }

    public final void j(Bundle r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        r103.put("source", r101);
        if (r100 == null) goto L5;
        String r104 = r100.getString("obric_skill_slug");
    L6:
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        r103.put("skill_id", r104);
        r103.put("reason", r102);
        paa.c r105 = this.f386760c;
        if (r105 == null) goto L13;
        boolean r106 = true;
        if (r105.Yb() != true) goto L13;
    L14:
        r103.put("cache_loaded", r106);
        r103.put("has_prefill", com.obric.assistant.chat.b.c(r100));
        FLogger.f375446a.i("ObricMentionInputController", "report obric_auto_mention_rejected: " + r103);
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L17
        IApplog.f287053a.reportEvent("obric_auto_mention_rejected", r103);     // Catch: Throwable -> L17
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L25;
        FLogger.f375446a.w("ObricMentionInputController", "report obric_auto_mention_rejected failed. " + r109.getMessage(), r109);
        return;
    L25:
        return;
    L17:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L13:
        r106 = false;
        goto L14
    L5:
        r104 = null;
        goto L6
    }

    public final void a(paa.e r100, String r101, final CharSequence r110, boolean r111) {
        ICoreInputAbility r102 = this.f386763f;
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L11;
        if (r111 == true) goto L11;
        return;
    L11:
        b();
        ObricMentionHighlightHelper.a r112 = this.f386765h;
        if (r112 != null) goto L15;
        return;
    L15:
        if (r110 != null) goto L17;
        this.f386759b.requestFocus();
        EditText r113 = this.f386759b;
        r113.setSelection(r113.length());
        r112.l(r100);
    L36:
        ICoreInputAbility r104 = this.f386763f;
        if (r104 == null) goto L39;
        r104.g2(3, true);
    L39:
        ICoreInputAbility r105 = this.f386763f;
        if (r105 == null) goto L54;
        ICoreInputAbility.b.e(r105, r101, null, false, 6);
        return;
    L54:
        return;
    L17:
        paa.c r106 = this.f386760c;
        if (r106 == null) goto L20;
        List<paa.e> r107 = r106.Nh();
    L21:
        if (r107 != null) goto L23;
        r107 = CollectionsKt.emptyList();
    L23:
        List r108 = CollectionsKt.plus(r107, r100);
        HashSet r109 = new HashSet();
        ArrayList r114 = new ArrayList();
        Iterator r115 = r108.iterator();
    L25:
        if (r115.hasNext() == false) goto L29;
        Object r116 = r115.next();
        if (r109.add(((paa.e) r116).f528396a) == false) goto L25;
        r114.add(r116);
        goto L25
    L29:
        Function0 r117 = new e(this, r110);
        Intrinsics.checkNotNullParameter(r114, "mentionItems");
        Intrinsics.checkNotNullParameter(r117, "updateText");
        r112.f393607i = true;
        r112.f393610l = null;
        r117.invoke();     // Catch: Throwable -> L43
        Iterator r118 = r114.iterator();     // Catch: Throwable -> L43
    L32:
        if (r118.hasNext() == false) goto L34;
        r112.f((paa.e) r118.next());     // Catch: Throwable -> L43
        goto L32
    L34:
        r112.g(r112.f393599a.getText());     // Catch: Throwable -> L43
        r112.f393607i = false;
        r112.o(r112.f393599a.getText());
    L43:
        th = move-exception;
        r112.f393607i = false;
        throw th;
    L20:
        r107 = null;
        goto L21
    L5:
        if (r102.Rp() != 2) goto L7;
        r103 = true;
        goto L8
    }

    public final boolean o(paa.e r100, List<String> r101, SkillSelectSource r102, boolean r103) {
        paa.c r104 = this.f386760c;
        if (r104 == null) goto L5;
        r104.hZ(r100, r102);
    L5:
        h();
        paa.c r105 = this.f386760c;
        if (r105 == null) goto L23;
        List<paa.e> r106 = r105.a00();
        if (r106 == null) goto L23;
        List<paa.e> r107 = r106;
        if ((r107 instanceof Collection) == true) goto L12;
    L14:
        Iterator<T> r108 = r107.iterator();
    L16:
        if (r108.hasNext() == false) goto L20;
        if (Intrinsics.areEqual(((paa.e) r108.next()).f528396a, r100.f528396a) == false) goto L16;
        boolean r109 = true;
    L21:
        if (r109 != true) goto L23;
        boolean r110 = true;
    L24:
        if (r110 == false) goto L52;
        if (r103 == false) goto L52;
        ArrayList r111 = new ArrayList();
        Iterator<T> r112 = r101.iterator();
    L29:
        if (r112.hasNext() == false) goto L33;
        Object r113 = r112.next();
        if (Intrinsics.areEqual((String) r113, r100.f528396a) == false) goto L29;
        r111.add(r113);
        goto L29
    L33:
        n(r111, r102);
        paa.c r114 = this.f386760c;
        if (r114 == null) goto L64;
        List<paa.e> r115 = r114.Nh();
        if (r115 == null) goto L65;
        List<paa.e> r116 = r115;
        if ((r116 instanceof Collection) == true) goto L40;
    L42:
        Iterator<T> r117 = r116.iterator();
    L44:
        if (r117.hasNext() == false) goto L48;
        if (Intrinsics.areEqual(((paa.e) r117.next()).f528396a, r100.f528396a) == false) goto L44;
        boolean r118 = true;
    L49:
        if (r118 != true) goto L66;
        return true;
    L66:
        return false;
    L48:
        r118 = false;
        goto L49
    L40:
        if (r116.isEmpty() == false) goto L42;
    L65:
        return false;
    L64:
        return false;
    L52:
        return r110;
    L20:
        r109 = false;
        goto L21
    L12:
        if (r107.isEmpty() == false) goto L14;
    L23:
        r110 = false;
        goto L24
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.obric.assistant.chat.component.bottom.core.mention.f] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.obric.assistant.chat.component.bottom.core.mention.g] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.obric.assistant.chat.component.bottom.core.mention.h] */
    public ObricMentionInputController(Context r100, EditText r101, paa.c r102, p1 r103, com.larus.bmhome.instruction.g r104, ICoreInputAbility r105, k r106) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "inputText");
        Intrinsics.checkNotNullParameter(r106, "chatArgumentDataProvider");
        this.f386758a = r100;
        this.f386759b = r101;
        this.f386760c = r102;
        this.f386761d = r103;
        this.f386762e = r104;
        this.f386763f = r105;
        this.f386764g = r106;
        this.f386769l = new f(this);
        this.f386770m = new g(this);
        this.f386771n = new h(this);
    }
}
