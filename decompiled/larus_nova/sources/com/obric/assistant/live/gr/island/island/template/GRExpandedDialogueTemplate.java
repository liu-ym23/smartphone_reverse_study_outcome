package com.obric.assistant.live.gr.island.island.template;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import pea.e;
import pea.f;
import pea.g;
import pea.h;
import pea.k;
import pea.l;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0001,B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0017J\b\u0010\u001e\u001a\u00020\u001dH\u0017J\b\u0010\u001f\u001a\u00020 H\u0016J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010%\u001a\u00020\u001a2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006-"}, d2 = {"Lcom/obric/assistant/live/gr/island/island/template/GRExpandedDialogueTemplate;", "Lcom/obric/assistant/live/gr/island/island/entity/ITemplateData;", "iconTextInfo", "Lcom/obric/assistant/live/gr/island/island/entity/ExpandedIconTextInfo;", "picInfo", "Lcom/obric/assistant/live/gr/island/island/entity/ExpandedIdentifyPicInfo;", "textButton", "", "Lcom/obric/assistant/live/gr/island/island/entity/ExpandedButtonActionInfo;", "<init>", "(Lcom/obric/assistant/live/gr/island/island/entity/ExpandedIconTextInfo;Lcom/obric/assistant/live/gr/island/island/entity/ExpandedIdentifyPicInfo;Ljava/util/List;)V", "getIconTextInfo", "()Lcom/obric/assistant/live/gr/island/island/entity/ExpandedIconTextInfo;", "setIconTextInfo", "(Lcom/obric/assistant/live/gr/island/island/entity/ExpandedIconTextInfo;)V", "getPicInfo", "()Lcom/obric/assistant/live/gr/island/island/entity/ExpandedIdentifyPicInfo;", "setPicInfo", "(Lcom/obric/assistant/live/gr/island/island/entity/ExpandedIdentifyPicInfo;)V", "getTextButton", "()Ljava/util/List;", "setTextButton", "(Ljava/util/List;)V", "create", "Lcom/obric/assistant/live/gr/island/island/entity/GRIslandWidget;", "isDefault", "", "(Ljava/lang/Boolean;)Lcom/obric/assistant/live/gr/island/island/entity/GRIslandWidget;", "getActions", "Landroid/os/Bundle;", "getPics", "toJSONObject", "Lorg/json/JSONObject;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GRExpandedDialogueTemplate implements l {
    public static final a Companion = null;
    private static final String TEMPLATE_ID = "com.obric.island_assistant:gr_common_expand_template_18";
    private f iconTextInfo;
    private g picInfo;
    private List<e> textButton;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GRExpandedDialogueTemplate copy$default(GRExpandedDialogueTemplate r100, f r101, g r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.iconTextInfo;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.picInfo;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.textButton;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final f component1() {
        return this.iconTextInfo;
    }

    public final g component2() {
        return this.picInfo;
    }

    public final List<e> component3() {
        return this.textButton;
    }

    public final GRExpandedDialogueTemplate copy(f r100, g r101, List<e> r102) {
        Intrinsics.checkNotNullParameter(r100, "iconTextInfo");
        Intrinsics.checkNotNullParameter(r101, "picInfo");
        Intrinsics.checkNotNullParameter(r102, "textButton");
        return new GRExpandedDialogueTemplate(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GRExpandedDialogueTemplate) == true) goto L8;
        return false;
    L8:
        GRExpandedDialogueTemplate r101 = (GRExpandedDialogueTemplate) r100;
        if (Intrinsics.areEqual(this.iconTextInfo, r101.iconTextInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.picInfo, r101.picInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.textButton, r101.textButton) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.iconTextInfo.hashCode() * 31) + this.picInfo.hashCode()) * 31) + this.textButton.hashCode();
    }

    public String toString() {
        return "GRExpandedDialogueTemplate(iconTextInfo=" + this.iconTextInfo + ", picInfo=" + this.picInfo + ", textButton=" + this.textButton + ')';
    }

    @Override // pea.l
    public Bundle getActions() {
        Bundle r100 = new Bundle();
        Iterator<T> r101 = this.textButton.iterator();
    L4:
        if (r101.hasNext() == false) goto L19;
        e r102 = (e) r101.next();
        Intent r103 = r102.f528756c;
        if (r102.f528754a != 0) goto L4;
        if (o0.d(r102.f528755b) == false) goto L4;
        if (r103 == null) goto L4;
        AppHost.Companion r104 = AppHost.f326268a;
        Context r105 = r104.getApplication().getApplicationContext();
        String r106 = r102.f528755b;
        if (r106 == null) goto L13;
        int r107 = r106.hashCode();
    L14:
        PendingIntent r108 = PendingIntent.getBroadcast(r105, r107, r103, 201326592);
        Integer r109 = r102.f528766m;
        if (r109 == null) goto L17;
        int r110 = r109.intValue();
        Icon r111 = Icon.createWithResource(r104.getApplication().getApplicationContext(), r110);
    L18:
        Notification.Action r112 = new Notification.Action.Builder(r111, r102.f528758e, r108).build();
        r100.putParcelable(r102.f528755b, r112);
        goto L4
    L17:
        r111 = null;
        goto L18
    L13:
        r107 = 0;
        goto L14
    L19:
        return r100;
    }

    @Override // pea.l
    public Bundle getPics() {
        Bundle r100 = new Bundle();
        r100.putParcelable(this.iconTextInfo.f528776g.f528750b, Icon.createWithResource(AppHost.f326268a.getApplication().getApplicationContext(), this.iconTextInfo.f528776g.f528751c));
        return r100;
    }

    @Override // pea.l
    public JSONObject toJSONObject() {
        JSONObject r100 = new JSONObject();
        r100.put("iconTextInfo", this.iconTextInfo.a());
        g r101 = this.picInfo;
        r101.getClass();
        JSONObject r102 = new JSONObject();
        r102.put("type", r101.f528777a);
        String r103 = r101.f528778b;
        if (r103 == null) goto L5;
        r102.put("pic", r103);
    L5:
        Integer r104 = r101.f528779c;
        if (r104 == null) goto L8;
        r102.put("picResId", r104.intValue());
    L8:
        String r105 = r101.f528780d;
        if (r105 == null) goto L11;
        r102.put("picDark", r105);
    L11:
        Integer r106 = r101.f528781e;
        if (r106 == null) goto L14;
        r102.put("picDarkResId", r106.intValue());
    L14:
        h r107 = r101.f528782f;
        if (r107 == null) goto L17;
        r102.put("actionInfo", r107.a());
    L17:
        r100.put("picInfo", r102);
        JSONArray r108 = new JSONArray();
        Iterator<T> r109 = this.textButton.iterator();
    L19:
        if (r109.hasNext() == false) goto L57;
        e r110 = (e) r109.next();
        r110.getClass();
        JSONObject r111 = new JSONObject();
        r111.put("clickWithCollapse", r110.f528757d);
        if (r110.f528754a != 0) goto L23;
        r111.put("action", r110.f528755b);
    L56:
        r108.put(r111);
        goto L19
    L23:
        String r112 = r110.f528758e;
        if (r112 == null) goto L26;
        r111.put("actionTitle", r112);
    L26:
        String r113 = r110.f528759f;
        if (r113 == null) goto L29;
        r111.put("actionTitleColor", r113);
    L29:
        String r114 = r110.f528760g;
        if (r114 == null) goto L32;
        r111.put("actionTitleColorDark", r114);
    L32:
        String r115 = r110.f528761h;
        if (r115 == null) goto L35;
        r111.put("actionBgColor", r115);
    L35:
        String r116 = r110.f528762i;
        if (r116 == null) goto L38;
        r111.put("actionBgColorDark", r116);
    L38:
        String r117 = r110.f528763j;
        if (r117 == null) goto L41;
        r111.put("actionBgPressColor", r117);
    L41:
        String r118 = r110.f528764k;
        if (r118 == null) goto L44;
        r111.put("actionBgPressColorDark", r118);
    L44:
        Intent r119 = r110.f528756c;
        if (r119 == null) goto L49;
        String r120 = r119.toUri(1);
        if (r120 == null) goto L49;
    L50:
        r110.f528768o = r120;
        if (r120 == null) goto L53;
        r111.put("actionIntent", r120);
    L53:
        Integer r121 = r110.f528767n;
        if (r121 == null) goto L56;
        r121.intValue();
        r111.put("actionIntentType", r110.f528767n);
    L49:
        r120 = null;
        goto L50
    L57:
        Unit r122 = Unit.INSTANCE;
        r100.put("textButton", r108);
        return r100;
    }

    public final f getIconTextInfo() {
        return this.iconTextInfo;
    }

    public final g getPicInfo() {
        return this.picInfo;
    }

    public final List<e> getTextButton() {
        return this.textButton;
    }

    @Override // pea.l
    public k create(Boolean r100) {
        return new k(TEMPLATE_ID, this, r100);
    }

    public final void setIconTextInfo(f r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.iconTextInfo = r100;
    }

    public final void setPicInfo(g r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.picInfo = r100;
    }

    public final void setTextButton(List<e> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.textButton = r100;
    }

    public GRExpandedDialogueTemplate(f r100, g r101, List<e> r102) {
        Intrinsics.checkNotNullParameter(r100, "iconTextInfo");
        Intrinsics.checkNotNullParameter(r101, "picInfo");
        Intrinsics.checkNotNullParameter(r102, "textButton");
        this.iconTextInfo = r100;
        this.picInfo = r101;
        this.textButton = r102;
    }

    public /* synthetic */ GRExpandedDialogueTemplate(f r100, g r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L5;
        r101 = new g(0);
    L5:
        this(r100, r101, r102);
    }
}
