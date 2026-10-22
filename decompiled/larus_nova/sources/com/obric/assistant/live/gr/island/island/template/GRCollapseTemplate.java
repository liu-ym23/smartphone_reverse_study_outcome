package com.obric.assistant.live.gr.island.island.template;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import pea.b;
import pea.c;
import pea.k;
import pea.l;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0001-B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0017J\u0012\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010&\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006."}, d2 = {"Lcom/obric/assistant/live/gr/island/island/template/GRCollapseTemplate;", "Lcom/obric/assistant/live/gr/island/island/entity/ITemplateData;", "imageTextInfoLeft", "Lcom/obric/assistant/live/gr/island/island/entity/BigIslandImageTextInfo;", "picInfo", "Lcom/obric/assistant/live/gr/island/island/entity/CollapseIslandPicInfo;", "textInfo", "Lcom/obric/assistant/live/gr/island/island/entity/BigIsLandTextInfo;", "<init>", "(Lcom/obric/assistant/live/gr/island/island/entity/BigIslandImageTextInfo;Lcom/obric/assistant/live/gr/island/island/entity/CollapseIslandPicInfo;Lcom/obric/assistant/live/gr/island/island/entity/BigIsLandTextInfo;)V", "getImageTextInfoLeft", "()Lcom/obric/assistant/live/gr/island/island/entity/BigIslandImageTextInfo;", "setImageTextInfoLeft", "(Lcom/obric/assistant/live/gr/island/island/entity/BigIslandImageTextInfo;)V", "getPicInfo", "()Lcom/obric/assistant/live/gr/island/island/entity/CollapseIslandPicInfo;", "setPicInfo", "(Lcom/obric/assistant/live/gr/island/island/entity/CollapseIslandPicInfo;)V", "getTextInfo", "()Lcom/obric/assistant/live/gr/island/island/entity/BigIsLandTextInfo;", "setTextInfo", "(Lcom/obric/assistant/live/gr/island/island/entity/BigIsLandTextInfo;)V", "create", "Lcom/obric/assistant/live/gr/island/island/entity/GRIslandWidget;", "isDefault", "", "(Ljava/lang/Boolean;)Lcom/obric/assistant/live/gr/island/island/entity/GRIslandWidget;", "toJSONObject", "Lorg/json/JSONObject;", "getActions", "Landroid/os/Bundle;", "getPics", "getIconFromPicInfo", "Landroid/graphics/drawable/Icon;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GRCollapseTemplate implements l {
    public static final a Companion = null;
    private static final String TAG = "GRCollapseTemplate";
    private static final String TEMPLATE_ID_2 = "com.obric.island_assistant:gr_common_collapse_template2";
    private static final String TEMPLATE_ID_8 = "com.obric.island_assistant:gr_common_collapse_template8";
    private b imageTextInfoLeft;
    private c picInfo;
    private pea.a textInfo;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ GRCollapseTemplate copy$default(GRCollapseTemplate r100, b r101, c r102, pea.a r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.imageTextInfoLeft;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.picInfo;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.textInfo;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final b component1() {
        return this.imageTextInfoLeft;
    }

    public final c component2() {
        return this.picInfo;
    }

    public final pea.a component3() {
        return this.textInfo;
    }

    public final GRCollapseTemplate copy(b r100, c r101, pea.a r102) {
        Intrinsics.checkNotNullParameter(r100, "imageTextInfoLeft");
        return new GRCollapseTemplate(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GRCollapseTemplate) == true) goto L8;
        return false;
    L8:
        GRCollapseTemplate r101 = (GRCollapseTemplate) r100;
        if (Intrinsics.areEqual(this.imageTextInfoLeft, r101.imageTextInfoLeft) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.picInfo, r101.picInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.textInfo, r101.textInfo) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.imageTextInfoLeft.hashCode() * 31;
        c r101 = this.picInfo;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        pea.a r105 = this.textInfo;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "GRCollapseTemplate(imageTextInfoLeft=" + this.imageTextInfoLeft + ", picInfo=" + this.picInfo + ", textInfo=" + this.textInfo + ')';
    }

    @Override // pea.l
    public Bundle getActions() {
        return new Bundle();
    }

    @Override // pea.l
    public Bundle getPics() {
        Bundle r100 = new Bundle();
        c r101 = this.imageTextInfoLeft.f528742b;
        if (r101 == null) goto L5;
        r100.putParcelable(r101.f528746b, Icon.createWithResource(AppHost.f326268a.getApplication().getApplicationContext(), r101.f528747c));
        FLogger.f375446a.d(TAG, "getPics: left picInfo " + r101);
    L5:
        c r102 = this.picInfo;
        if (r102 == null) goto L11;
        Icon r103 = getIconFromPicInfo(r102);
        if (r103 == null) goto L10;
        r100.putParcelable(r102.f528746b, r103);
    L10:
        FLogger.f375446a.d(TAG, "getPics: right picInfo " + r102);
    L11:
        return r100;
    }

    @Override // pea.l
    public JSONObject toJSONObject() {
        JSONObject r100 = new JSONObject();
        b r101 = this.imageTextInfoLeft;
        r101.getClass();
        JSONObject r102 = new JSONObject();
        r102.put("type", r101.f528741a);
        c r103 = r101.f528742b;
        if (r103 == null) goto L5;
        r102.put("picInfo", r103.a());
    L5:
        pea.a r104 = r101.f528743c;
        if (r104 == null) goto L8;
        r102.put("textInfo", r104.a());
    L8:
        r100.put("imageTextInfoLeft", r102);
        c r105 = this.picInfo;
        if (r105 == null) goto L11;
        r100.put("picInfo", r105.a());
    L11:
        pea.a r106 = this.textInfo;
        if (r106 == null) goto L14;
        r100.put("textInfo", r106.a());
    L14:
        return r100;
    }

    public final b getImageTextInfoLeft() {
        return this.imageTextInfoLeft;
    }

    public final c getPicInfo() {
        return this.picInfo;
    }

    public final pea.a getTextInfo() {
        return this.textInfo;
    }

    private final Icon getIconFromPicInfo(c r100) {
        String r101 = r100.f528748d;
        if (r101 == null) goto L17;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L6
        Object r103 = Result.m9449constructorimpl(Icon.createWithResource(r101, r100.f528747c));     // Catch: Throwable -> L6
    L9:
        if (Result.m9452exceptionOrNullimpl(r103) == null) goto L12;
        FLogger.f375446a.e(TAG, "getIconFromPicInfo: createWithResource failed, packageName:" + r101 + ", picResId:" + r100.f528747c);
    L12:
        if (Result.m9455isFailureimpl(r103) == false) goto L15;
        r103 = null;
    L15:
        return (Icon) r103;
    L6:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    L17:
        return Icon.createWithResource(AppHost.f326268a.getApplication().getApplicationContext(), r100.f528747c);
    }

    @Override // pea.l
    public k create(Boolean r100) {
        if (this.picInfo == null) goto L5;
        String r101 = TEMPLATE_ID_8;
    L7:
        return new k(r101, this, r100);
    L5:
        r101 = TEMPLATE_ID_2;
        goto L7
    }

    public final void setImageTextInfoLeft(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.imageTextInfoLeft = r100;
    }

    public final void setPicInfo(c r100) {
        this.picInfo = r100;
    }

    public final void setTextInfo(pea.a r100) {
        this.textInfo = r100;
    }

    public GRCollapseTemplate(b r100, c r101, pea.a r102) {
        Intrinsics.checkNotNullParameter(r100, "imageTextInfoLeft");
        this.imageTextInfoLeft = r100;
        this.picInfo = r101;
        this.textInfo = r102;
    }

    public /* synthetic */ GRCollapseTemplate(b r100, c r101, pea.a r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102);
    }
}
