package ny9;

import android.os.Bundle;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.livetutor.impl.home.viewmodel.LiveTutorHomeVM;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.obric.trace.ObricActionBarTrackType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class u implements t1a.c, zs8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f521280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f521281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f521282c;

    public u() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f521280a, ((u) r100).f521280a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        s r100 = this.f521280a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "InstructionHitPointData(instructionArgumentData=" + this.f521280a + ')';
    }

    @Override // zs8.a
    public final String Y1() {
        cy9.a r100 = cy9.a.f465949a;
        s r101 = this.f521280a;
        if (r101 == null) goto L5;
        Bundle r102 = r101.f521269a;
    L6:
        Bundle r103 = r100.c(r102);
        if (r103 == null) goto L9;
        Bundle r104 = r103.getBundle("instruction_hit_point_params");
    L10:
        if (r104 != null) goto L12;
        r104 = this.f521282c;
    L12:
        if (r104 != null) goto L14;
        return null;
    L14:
        return r104.getString("conversation_id");
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // zs8.a
    public final String a() {
        Bundle r100 = this.f521282c;
        if (r100 == null) goto L6;
        String r101 = r100.getString("action_bar_key");
        if (r101 == null) goto L6;
        return r101;
    L6:
        s r102 = this.f521280a;
        if (r102 == null) goto L13;
        z0 r103 = r102.f();
        if (r103 == null) goto L13;
        String r104 = r103.f295606b;
        if (r104 == null) goto L13;
        return r104;
    L13:
        return null;
    }

    @Override // zs8.a
    public final String b() {
        Bundle r100 = this.f521282c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getString("previous_page");
    }

    @Override // zs8.a
    public final String c() {
        cy9.a r100 = cy9.a.f465949a;
        s r101 = this.f521280a;
        if (r101 == null) goto L5;
        Bundle r102 = r101.f521269a;
    L6:
        Bundle r103 = r100.c(r102);
        if (r103 == null) goto L9;
        Bundle r104 = r103.getBundle("instruction_hit_point_params");
    L11:
        if (r104 != null) goto L13;
        Bundle r105 = this.f521282c;
        if (r105 == null) goto L20;
        String r106 = r105.getString(LiveTutorHomeVM.ACTION_BAR_ITEM_ID);
        if (r106 == null) goto L20;
        return r106;
    L20:
        s r107 = this.f521280a;
        if (r107 == null) goto L29;
        z0 r108 = r107.f();
        if (r108 == null) goto L30;
        Long r109 = r108.f295605a;
        if (r109 != null) goto L27;
        return null;
    L27:
        return r109.toString();
    L30:
        return null;
    L29:
        return null;
    L13:
        return r104.getString(LiveTutorHomeVM.ACTION_BAR_ITEM_ID);
    L9:
        r104 = null;
        goto L11
    L5:
        r102 = null;
        goto L6
    }

    @Override // zs8.a
    public final String d() {
        Bundle r100 = this.f521282c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getString("bundle_template_sub_type");
    }

    @Override // zs8.a
    public final String e() {
        Bundle r100 = this.f521282c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getString("prompt_type");
    }

    @Override // zs8.a
    public final String f() {
        Bundle r100 = this.f521282c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getString("ai_generate_tab_id");
    }

    @Override // zs8.a
    public final String g() {
        Bundle r100 = this.f521282c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getString("tag_code");
    }

    @Override // zs8.a
    public final String getBotId() {
        cy9.a r100 = cy9.a.f465949a;
        s r101 = this.f521280a;
        if (r101 == null) goto L5;
        Bundle r102 = r101.f521269a;
    L6:
        Bundle r103 = r100.c(r102);
        if (r103 == null) goto L9;
        Bundle r104 = r103.getBundle("instruction_hit_point_params");
    L10:
        if (r104 != null) goto L12;
        r104 = this.f521282c;
    L12:
        if (r104 != null) goto L14;
        return null;
    L14:
        return r104.getString("bot_id");
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // zs8.a
    public final String getChatType() {
        cy9.a r100 = cy9.a.f465949a;
        s r101 = this.f521280a;
        if (r101 == null) goto L5;
        Bundle r102 = r101.f521269a;
    L6:
        Bundle r103 = r100.c(r102);
        if (r103 == null) goto L9;
        Bundle r104 = r103.getBundle("instruction_hit_point_params");
    L10:
        if (r104 != null) goto L12;
        r104 = this.f521282c;
    L12:
        if (r104 != null) goto L14;
        return null;
    L14:
        return r104.getString("chat_type");
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // zs8.a
    public final String getClickFrom() {
        Bundle r100 = this.f521282c;
        if (r100 == null) goto L5;
        String r101 = r100.getString("click_from");
    L6:
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        if (r101.length() != 0) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L15;
        return "ai_generate_feed_image";
    L15:
        return r101;
    L11:
        r102 = false;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    @Override // zs8.a
    public final String getEnterMethod() {
        cy9.a r100 = cy9.a.f465949a;
        s r101 = this.f521280a;
        String r102 = null;
        if (r101 == null) goto L5;
        Bundle r103 = r101.f521269a;
    L6:
        Bundle r104 = r100.c(r103);
        if (r104 == null) goto L9;
        Bundle r105 = r104.getBundle("instruction_hit_point_params");
    L10:
        if (r105 != null) goto L12;
        r105 = this.f521282c;
    L12:
        if (r105 == null) goto L14;
        r102 = r105.getString("enter_method");
    L14:
        if (r102 != null) goto L17;
        return "";
    L17:
        return r102;
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    @Override // zs8.a
    public final String getTemplateType() {
        Bundle r100 = this.f521282c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getString("bundle_template_type");
    }

    @Override // zs8.a
    public final String h() {
        Bundle r100 = this.f521282c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getString("ai_creation_recommend_from");
    }

    @Override // zs8.a
    public final String i() {
        Bundle r100 = this.f521282c;
        if (r100 == null) goto L6;
        String r101 = r100.getString("action_bar_template_type");
        if (r101 == null) goto L6;
        return r101;
    L6:
        s r102 = this.f521280a;
        if (r102 == null) goto L11;
        com.larus.bmhome.actionbar.model.r r103 = r102.k();
        if (r103 == null) goto L11;
        return r103.f295414g;
    L11:
        return null;
    }

    @Override // zs8.a
    public final String j() {
        Bundle r100 = this.f521282c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getString("ai_generate_tab_type");
    }

    @Override // zs8.a
    public final String k() {
        Bundle r100 = this.f521282c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getString("visual_size");
    }

    @Override // zs8.a
    public final boolean l() {
        Bundle r100 = this.f521282c;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.getBoolean("enable_show_update_dialog");
    }

    @Override // zs8.a
    public final String m() {
        Bundle r100 = this.f521282c;
        if (r100 == null) goto L6;
        String r101 = r100.getString(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID);
        if (r101 == null) goto L6;
        return r101;
    L6:
        s r102 = this.f521280a;
        if (r102 == null) goto L13;
        com.larus.bmhome.actionbar.model.r r103 = r102.k();
        if (r103 == null) goto L13;
        Integer r104 = r103.f295408a;
        if (r104 == null) goto L13;
        return r104.toString();
    L13:
        return null;
    }

    @Override // zs8.a
    public final String n() {
        Bundle r100 = this.f521282c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getString("prompt_from");
    }

    @Override // zs8.a
    public final String o() {
        Bundle r100 = this.f521282c;
        if (r100 == null) goto L6;
        String r101 = r100.getString("reference_image_scene");
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // zs8.a
    public final String p() {
        Bundle r100 = this.f521282c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getString("ai_generate_tab_name");
    }

    public final String q() {
        s r100 = this.f521280a;
        String r101 = null;
        if (r100 == null) goto L5;
        com.larus.bmhome.actionbar.model.r r102 = r100.k();
    L6:
        if (r102 == null) goto L8;
        Integer r103 = r102.f295408a;
    L9:
        if (r103 != null) goto L12;
    L13:
        if (r103 != null) goto L16;
    L18:
        if (r103 != null) goto L21;
    L22:
        if (r103 != null) goto L25;
    L27:
        if (r103 != null) goto L30;
    L32:
        Bundle r104 = this.f521282c;
        if (r104 == null) goto L35;
        r101 = r104.getString("current_page");
    L35:
        if (r101 != null) goto L43;
        return "";
    L43:
        return r101;
    L30:
        if (r103.intValue() != 28) goto L32;
        return "ai_generate_feed";
    L25:
        if (r103.intValue() != 24) goto L27;
    L38:
        return "video_generate";
    L21:
        if (r103.intValue() == 18) goto L38;
    L16:
        if (r103.intValue() != 16) goto L18;
    L39:
        return "image_generate";
    L12:
        if (r103.intValue() == 4) goto L39;
    L8:
        r103 = null;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    public final String r() {
        s r100 = this.f521280a;
        Integer r101 = null;
        if (r100 == null) goto L5;
        com.larus.bmhome.actionbar.model.r r102 = r100.k();
    L6:
        if (r102 == null) goto L9;
        r101 = r102.f295408a;
    L9:
        if (r101 != null) goto L12;
    L13:
        if (r101 != null) goto L16;
    L18:
        if (r101 != null) goto L21;
        return "ai_generate_feed_image";
    L21:
        if (r101.intValue() != 18) goto L25;
        return "ai_generate_feed_video";
    L25:
        return "ai_generate_feed_image";
    L16:
        if (r101.intValue() != 16) goto L18;
        return "ai_generate_feed_image";
    L12:
        if (r101.intValue() != 4) goto L13;
        return "ai_generate_feed_image";
    L5:
        r102 = null;
        goto L6
    }

    public u(s r100) {
        this.f521280a = r100;
        this.f521281b = System.currentTimeMillis();
        if (r100 == null) goto L7;
        Bundle r101 = r100.f521269a;
        if (r101 == null) goto L7;
        Bundle r102 = r101.getBundle("instruction_hit_point_params");
    L8:
        this.f521282c = r102;
        return;
    L7:
        r102 = null;
        goto L8
    }

    public final void s(UserCreation r100) {
        Bundle r101 = this.f521282c;
        String r102 = null;
        if (r101 == null) goto L10;
        if (r100 == null) goto L8;
        UserCreationTrackParams r103 = r100.f365000n;
        if (r103 == null) goto L8;
        String r104 = r103.f365043d;
    L9:
        r101.putString("ai_generate_tab_id", r104);
    L8:
        r104 = null;
    L10:
        Bundle r105 = this.f521282c;
        if (r105 == null) goto L18;
        if (r100 == null) goto L16;
        UserCreationTrackParams r106 = r100.f365000n;
        if (r106 == null) goto L16;
        String r107 = r106.f365044e;
    L17:
        r105.putString("ai_generate_tab_name", r107);
    L16:
        r107 = null;
    L18:
        Bundle r108 = this.f521282c;
        if (r108 == null) goto L26;
        if (r100 == null) goto L24;
        UserCreationTrackParams r109 = r100.f365000n;
        if (r109 == null) goto L24;
        String r110 = r109.f365045f;
    L25:
        r108.putString("ai_generate_tab_type", r110);
    L24:
        r110 = null;
    L26:
        Bundle r111 = this.f521282c;
        if (r111 == null) goto L32;
        if (r100 == null) goto L30;
        String r112 = zp9.d.d(r100);
    L31:
        r111.putString("bundle_template_type", r112);
        goto L32
    L30:
        r112 = null;
    L32:
        Bundle r113 = this.f521282c;
        if (r113 == null) goto L38;
        if (r100 == null) goto L36;
        r102 = zp9.d.c(r100);
    L36:
        r113.putString("bundle_template_sub_type", r102);
        return;
    }
}
