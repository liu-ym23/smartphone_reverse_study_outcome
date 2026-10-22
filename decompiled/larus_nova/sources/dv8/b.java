package dv8;

import android.os.Bundle;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.bean.ContentType;
import com.larus.bot.impl.feature.edit.BotCreateViewModel;
import com.larus.bot.impl.feature.edit.feature.firstmet.k;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.FirstMet;
import com.larus.im.bean.bot.SpeakerVoice;
import java.util.List;
import java.util.UUID;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f470213g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BotCreateViewModel f470214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f470215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f470216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f470217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f470218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f470219f;

    public static final class a {
        public static String a() {
            StringBuilder r100 = new StringBuilder();
            r100.append(UUID.randomUUID());
            r100.append('_');
            r100.append(System.currentTimeMillis());
            return r100.toString();
        }
    }

    /* JADX INFO: renamed from: dv8.b$b, reason: collision with other inner class name */
    public static final class C5712b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Boolean f470220a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f470221b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Boolean f470222c;

        public C5712b(Boolean r100, Integer r101, Boolean r102) {
            this.f470220a = r100;
            this.f470221b = r101;
            this.f470222c = r102;
        }
    }

    static {
    }

    public final boolean a() {
        BgImage r100 = this.f470214a.getEditParam().getBgImage();
        if (r100 == null) goto L9;
        BgImageInfo r101 = r100.bgImageInfo;
        if (r101 == null) goto L9;
        Boolean r102 = r101.getBgImgOpen();
        if (r102 == null) goto L9;
        return r102.booleanValue();
    L9:
        return false;
    }

    public final String c() {
        String r100 = this.f470215b.getString("create_way", "");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String d() {
        String r100 = "";
        String r101 = this.f470215b.getString("creation_id", "");
        if (r101 == null) goto L7;
        r100 = r101;
    L7:
        if (r100.length() != 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
        String r103 = a.a();
        this.f470215b.putString("creation_id", r103);
        return r103;
    L13:
        return r100;
    L9:
        r102 = false;
        goto L10
    }

    public final String e() {
        BgImage r100 = this.f470214a.getEditParam().getBgImage();
        if (r100 == null) goto L7;
        BgImageInfo r101 = r100.bgImageInfo;
        if (r101 == null) goto L7;
        boolean r102 = Intrinsics.areEqual(r101.getAiGenBgImg(), Boolean.TRUE);
    L9:
        if (r102 == false) goto L12;
        return "ai_generate";
    L12:
        if (StringsKt.isBlank(this.f470214a.getEditParam().getIconUri()) == false) goto L14;
        return "default";
    L14:
        String r103 = this.f470214a.getEditParam().getIconUri();
        wu8.d r104 = this.f470214a.getLatestAutoFilledBotAvatarData();
        if (r104 == null) goto L19;
        BotAvatarIconData r105 = r104.f561483a;
        if (r105 == null) goto L19;
        String r106 = r105.getIconUri();
    L21:
        if (Intrinsics.areEqual(r103, r106) == true) goto L27;
        return "uploaded";
    L27:
        return "ai_generate";
    L19:
        r106 = null;
    L7:
        r102 = false;
        goto L9
    }

    public final String f() {
        String r100 = this.f470215b.getString("enter_method", "");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final C5712b g() {
        FirstMet r100 = this.f470214a.getFirstMetData();
        String r101 = r100.getPrologue();
        boolean r102 = true;
        Integer r103 = null;
        if (r101 == null) goto L5;
        Boolean r104 = Boolean.valueOf(!StringsKt.isBlank(r101));
    L6:
        List<String> r105 = r100.getSuggests();
        if (r105 == null) goto L9;
        r103 = Integer.valueOf(r105.size());
    L9:
        Boolean r106 = r100.getSuggestSwitch();
        if (r106 == null) goto L13;
        r102 = r106.booleanValue();
    L13:
        return new C5712b(r104, r103, Boolean.valueOf(r102));
    L5:
        r104 = null;
        goto L6
    }

    public final String h() {
        String r100 = "";
        String r101 = this.f470215b.getString("from_activity_module", "");
        if (r101 == null) goto L7;
        r100 = r101;
    L7:
        if (r100.length() != 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
        return null;
    L13:
        return r100;
    L9:
        r102 = false;
        goto L10
    }

    public final String i() {
        String r100 = "";
        String r101 = this.f470215b.getString("from_activity_name", "");
        if (r101 == null) goto L7;
        r100 = r101;
    L7:
        if (r100.length() != 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
        return null;
    L13:
        return r100;
    L9:
        r102 = false;
        goto L10
    }

    public final boolean j() {
        return this.f470214a.hasUsedAutoFill();
    }

    public final boolean k() {
        return this.f470214a.hasUsedPolishDesc();
    }

    public final String l() {
        BgImage r100 = this.f470214a.getEditParam().getBgImage();
        if (r100 == null) goto L5;
        String r101 = r100.bgImgUri;
    L6:
        if (r101 != null) goto L8;
        return "no_image";
    L8:
        BgImage r102 = this.f470214a.getEditParam().getBgImage();
        if (r102 == null) goto L13;
        BgImageInfo r103 = r102.bgImageInfo;
        if (r103 == null) goto L13;
        boolean r104 = Intrinsics.areEqual(r103.getAiGenBgImg(), Boolean.TRUE);
    L14:
        if (r104 == false) goto L16;
        return "ai_generate";
    L16:
        return "uploaded";
    L13:
        r104 = false;
        goto L14
    L5:
        r101 = null;
        goto L6
    }

    public final int m() {
        return this.f470214a.getPolishCnt();
    }

    public final String o() {
        String r100 = "";
        String r101 = this.f470215b.getString("previous_page", "");
        if (r101 == null) goto L7;
        r100 = r101;
    L7:
        if (r100.length() != 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
        return null;
    L13:
        return r100;
    L9:
        r102 = false;
        goto L10
    }

    public final boolean p() {
        return !StringsKt.isBlank(this.f470214a.getEditParam().getBio());
    }

    public final boolean q() {
        String r100 = "";
        List r101 = CollectionsKt.listOf(new String[]{"0", ""});
        SpeakerVoice r102 = this.f470214a.getEditParam().getVoice();
        if (r102 == null) goto L5;
        String r103 = r102.getId();
    L6:
        if (r103 == null) goto L10;
        r100 = r103;
    L10:
        return !r101.contains(r100);
    L5:
        r103 = null;
        goto L6
    }

    public final String r() {
        if (StringsKt.isBlank(this.f470214a.getEditParam().getName()) == false) goto L5;
        return "empty";
    L5:
        List<String> r100 = this.f470214a.getLatestAutoFilledBotEnrichData().get(ContentType.NAME.getValue());
        if (r100 == null) goto L8;
        String r101 = (String) CollectionsKt.firstOrNull(r100);
    L9:
        if (r101 != null) goto L11;
    L14:
        boolean r102 = true;
    L15:
        if (r102 == false) goto L18;
        return "manual_fill";
    L18:
        if (Intrinsics.areEqual(r101, this.f470214a.getEditParam().getName()) == false) goto L20;
        return "auto_fill";
    L20:
        return "auto_fill_manual_change";
    L11:
        if (StringsKt.isBlank(r101) == true) goto L14;
        r102 = false;
        goto L15
    L8:
        r101 = null;
        goto L9
    }

    public final String s() {
        String r100 = this.f470214a.getFirstMetData().getPrologue();
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L10;
        return "empty";
    L10:
        List<String> r103 = this.f470214a.getLatestAutoFilledBotEnrichData().get(ContentType.PROLOGUE.getValue());
        if (r103 == null) goto L13;
        String r104 = (String) CollectionsKt.firstOrNull(r103);
    L14:
        if (r104 != null) goto L16;
    L17:
        r101 = true;
    L18:
        if (r101 == false) goto L21;
        return "manual_fill";
    L21:
        if (Intrinsics.areEqual(r104, this.f470214a.getEditParam().getPrologue()) == false) goto L23;
        return "auto_fill";
    L23:
        return "auto_fill_manual_change";
    L16:
        if (StringsKt.isBlank(r104) == false) goto L18;
    L13:
        r104 = null;
        goto L14
    L5:
        if ((!StringsKt.isBlank(r100)) != true) goto L7;
        r102 = true;
        goto L8
    }

    public final String t() {
        if (StringsKt.isBlank(this.f470214a.getEditParam().getIconUri()) == false) goto L5;
        return "empty";
    L5:
        wu8.d r100 = this.f470214a.getLatestAutoFilledBotAvatarData();
        if (r100 == null) goto L10;
        BotAvatarIconData r101 = r100.f561483a;
        if (r101 == null) goto L10;
        String r102 = r101.getIconUri();
    L11:
        if (r102 != null) goto L13;
    L16:
        boolean r103 = true;
    L17:
        if (r103 == false) goto L20;
        return "manual_fill";
    L20:
        if (Intrinsics.areEqual(r102, this.f470214a.getEditParam().getIconUri()) == false) goto L22;
        return "auto_fill";
    L22:
        return "auto_fill_manual_change";
    L13:
        if (StringsKt.isBlank(r102) == true) goto L16;
        r103 = false;
    L10:
        r102 = null;
        goto L11
    }

    public final String v() {
        if (StringsKt.isBlank(this.f470214a.getEditParam().getDescription()) == false) goto L5;
        return "empty";
    L5:
        List<String> r100 = this.f470214a.getLatestAutoFilledBotEnrichData().get(ContentType.DESC.getValue());
        if (r100 == null) goto L8;
        String r101 = (String) CollectionsKt.firstOrNull(r100);
    L9:
        if (r101 != null) goto L11;
    L14:
        boolean r102 = true;
    L15:
        if (r102 == false) goto L18;
        return "manual_fill";
    L18:
        if (j() == true) goto L21;
        return "manual_fill_polish";
    L21:
        if (Intrinsics.areEqual(r101, this.f470214a.getEditParam().getDescription()) == false) goto L27;
        if (k() == false) goto L25;
        return "auto_fill_polish";
    L25:
        return "auto_fill";
    L27:
        if (k() == false) goto L29;
        return "auto_fill_polish_manual_change";
    L29:
        return "auto_fill_manual_change";
    L11:
        if (StringsKt.isBlank(r101) == true) goto L14;
        r102 = false;
        goto L15
    L8:
        r101 = null;
        goto L9
    }

    public final String w() {
        Triple<String, String, String> r100 = this.f470214a.getEditParam().getSuggests();
        boolean r101 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L10;
        return "empty";
    L10:
        List<String> r103 = this.f470214a.getLatestAutoFilledBotEnrichData().get(ContentType.SUGGEST.getValue());
        Triple<String, String, String> r104 = this.f470214a.getEditParam().getSuggests();
        Integer r105 = null;
        if (r104 == null) goto L13;
        List r106 = TuplesKt.toList(r104);
    L14:
        List<String> r107 = r103;
        if (r107 != null) goto L17;
    L20:
        if (r101 == false) goto L22;
        return "manual_fill";
    L22:
        if (r103 == null) goto L24;
        Integer r108 = Integer.valueOf(r103.size());
    L25:
        if (r106 == null) goto L28;
        r105 = Integer.valueOf(r106.size());
    L28:
        if (Intrinsics.areEqual(r108, r105) == false) goto L36;
        if (r103 != null) goto L31;
        r103 = CollectionsKt.emptyList();
    L31:
        if (r106 != null) goto L34;
        r106 = CollectionsKt.emptyList();
    L34:
        if (r103.containsAll(r106) == false) goto L36;
        return "auto_fill";
    L36:
        return "auto_fill_manual_change";
    L24:
        r108 = null;
        goto L25
    L17:
        if (r107.isEmpty() == true) goto L20;
        r101 = false;
        goto L20
    L13:
        r106 = null;
        goto L14
    L5:
        if (k.a(r100) != true) goto L7;
        r102 = true;
        goto L8
    }

    public final String b() {
        if (p() == true) goto L5;
        return "empty";
    L5:
        List<String> r100 = this.f470214a.getLatestAutoFilledBotEnrichData().get(ContentType.BIO.getValue());
        if (r100 == null) goto L8;
        String r101 = (String) CollectionsKt.firstOrNull(r100);
    L9:
        if (r101 != null) goto L11;
    L14:
        boolean r102 = true;
    L15:
        if (r102 == false) goto L18;
        return "manual_fill";
    L18:
        if (Intrinsics.areEqual(r101, this.f470214a.getEditParam().getBio()) == false) goto L20;
        return "auto_fill";
    L20:
        return "auto_fill_manual_change";
    L11:
        if (StringsKt.isBlank(r101) == true) goto L14;
        r102 = false;
        goto L15
    L8:
        r101 = null;
        goto L9
    }

    public final String n() {
        if (k() == true) goto L5;
        return null;
    L5:
        if (this.f470214a.isPolishUndo() == false) goto L7;
        return "0";
    L7:
        return "1";
    }

    public final String x() {
        if (q() == true) goto L5;
        return "empty";
    L5:
        List<String> r100 = this.f470214a.getLatestAutoFilledBotEnrichData().get(ContentType.VOICE_ID.getValue());
        String r101 = null;
        if (r100 == null) goto L8;
        String r102 = (String) CollectionsKt.firstOrNull(r100);
    L9:
        if (r102 != null) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == false) goto L17;
        return "manual_fill";
    L17:
        SpeakerVoice r104 = this.f470214a.getEditParam().getVoice();
        if (r104 == null) goto L21;
        r101 = r104.getId();
    L21:
        if (Intrinsics.areEqual(r102, r101) == false) goto L23;
        return "auto_fill";
    L23:
        return "auto_fill_manual_change";
    L11:
        if (StringsKt.isBlank(r102) == true) goto L14;
        r103 = false;
        goto L15
    L8:
        r102 = null;
        goto L9
    }

    public b(BotCreateViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        this.f470214a = r100;
        this.f470215b = new Bundle();
        this.f470216c = "";
        this.f470217d = "";
        this.f470218e = "";
        this.f470219f = "create";
    }

    public final void u(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (Intrinsics.areEqual(r100, this.f470216c) == true) goto L6;
        this.f470215b.putString("create_way", r100);
        return;
    }
}
