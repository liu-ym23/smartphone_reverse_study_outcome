package com.obric.livecard.api.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u0000 O2\u00020\u0001:\u0001OB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0095\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u001e\b\u0002\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00160\u0015j\u0002`\u00170\u0014\u0012\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\u0004\u0018\u0001`\u0017¢\u0006\u0002\u0010\u0019J \u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u00062\u0010\u0010:\u001a\f\u0012\u0004\u0012\u00020\u00160\u0015j\u0002`\u0017J\t\u0010;\u001a\u00020\u0006HÆ\u0003J\t\u0010<\u001a\u00020\bHÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010>\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0011\u0010?\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u0011\u0010@\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u001f\u0010B\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00160\u0015j\u0002`\u00170\u0014HÆ\u0003J\u0017\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\u0004\u0018\u0001`\u0017HÆ\u0003J¢\u0001\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u001e\b\u0002\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00160\u0015j\u0002`\u00170\u00142\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\u0004\u0018\u0001`\u0017HÆ\u0001¢\u0006\u0002\u0010EJ\b\u0010F\u001a\u00020GH\u0016J\u0013\u0010H\u001a\u00020\n2\b\u0010I\u001a\u0004\u0018\u00010\bHÖ\u0003J\u001c\u0010J\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\u0004\u0018\u0001`\u00172\u0006\u00109\u001a\u00020\u0006J\t\u0010K\u001a\u00020GHÖ\u0001J\b\u0010L\u001a\u00020\u0006H\u0016J\u0018\u0010M\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010N\u001a\u00020GH\u0016R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010#\u001a\u0004\b\t\u0010\"R(\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\u0004\u0018\u0001`\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R0\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00160\u0015j\u0002`\u00170\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006P"}, d2 = {"Lcom/obric/livecard/api/entity/IslandWidget;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", GXTemplateKey.GAIAX_TEMPLATE_ID, "", "templateData", "", "isDefault", "", "view", "Landroid/view/View;", "inAnimation", "", "Lcom/obric/livecard/api/entity/TransitionAnimation;", "outAnimation", "ext", "Lcom/google/gson/JsonObject;", "onClickCallback", "", "Lkotlin/Function0;", "", "Lcom/obric/livecard/api/entity/OnViewClickListener;", "onCardClickCallback", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Boolean;Landroid/view/View;Ljava/util/List;Ljava/util/List;Lcom/google/gson/JsonObject;Ljava/util/Map;Lkotlin/jvm/functions/Function0;)V", "getExt", "()Lcom/google/gson/JsonObject;", "setExt", "(Lcom/google/gson/JsonObject;)V", "getInAnimation", "()Ljava/util/List;", "setInAnimation", "(Ljava/util/List;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getOnCardClickCallback", "()Lkotlin/jvm/functions/Function0;", "setOnCardClickCallback", "(Lkotlin/jvm/functions/Function0;)V", "getOnClickCallback", "()Ljava/util/Map;", "setOnClickCallback", "(Ljava/util/Map;)V", "getOutAnimation", "setOutAnimation", "getTemplateData", "()Ljava/lang/Object;", "setTemplateData", "(Ljava/lang/Object;)V", "getTemplateId", "()Ljava/lang/String;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "addOnViewClickCallback", "viewId", SendEventContainerMethodParamModel.EventKinds.onClick, "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Boolean;Landroid/view/View;Ljava/util/List;Ljava/util/List;Lcom/google/gson/JsonObject;Ljava/util/Map;Lkotlin/jvm/functions/Function0;)Lcom/obric/livecard/api/entity/IslandWidget;", "describeContents", "", "equals", "other", "findOnViewClickCallbackById", "hashCode", "toString", "writeToParcel", "flags", "CREATOR", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IslandWidget implements Parcelable {
    public static final CREATOR CREATOR = null;
    private JsonObject ext;
    private List<? extends TransitionAnimation> inAnimation;
    private final Boolean isDefault;
    private Function0<Unit> onCardClickCallback;
    private Map<String, Function0<Unit>> onClickCallback;
    private List<? extends TransitionAnimation> outAnimation;
    private Object templateData;
    private final String templateId;
    private View view;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/livecard/api/entity/IslandWidget$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/livecard/api/entity/IslandWidget;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/livecard/api/entity/IslandWidget;", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<IslandWidget> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IslandWidget createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new IslandWidget(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IslandWidget[] newArray(int r100) {
            return newArray(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IslandWidget createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IslandWidget[] newArray(int r100) {
            return new IslandWidget[r100];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IslandWidget copy$default(IslandWidget r110, String r111, Object r112, Boolean r113, View r114, List r115, List r116, JsonObject r117, Map r118, Function0 r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.templateId;
    L7:
        if ((r210 & 2) == 0) goto L9;
        Object r101 = r110.templateData;
    L11:
        if ((r210 & 4) == 0) goto L13;
        Boolean r102 = r110.isDefault;
    L15:
        if ((r210 & 8) == 0) goto L17;
        View r103 = r110.view;
    L19:
        if ((r210 & 16) == 0) goto L21;
        List r104 = r110.inAnimation;
    L23:
        if ((r210 & 32) == 0) goto L25;
        List r105 = r110.outAnimation;
    L27:
        if ((r210 & 64) == 0) goto L29;
        JsonObject r106 = r110.ext;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Map r107 = r110.onClickCallback;
    L35:
        if ((r210 & 256) == 0) goto L37;
        Function0 r108 = r110.onCardClickCallback;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.templateId;
    }

    public final Object component2() {
        return this.templateData;
    }

    public final Boolean component3() {
        return this.isDefault;
    }

    public final View component4() {
        return this.view;
    }

    public final List<TransitionAnimation> component5() {
        return this.inAnimation;
    }

    public final List<TransitionAnimation> component6() {
        return this.outAnimation;
    }

    public final JsonObject component7() {
        return this.ext;
    }

    public final Map<String, Function0<Unit>> component8() {
        return this.onClickCallback;
    }

    public final Function0<Unit> component9() {
        return this.onCardClickCallback;
    }

    public final IslandWidget copy(String r110, Object r111, Boolean r112, View r113, List<? extends TransitionAnimation> r114, List<? extends TransitionAnimation> r115, JsonObject r116, Map<String, Function0<Unit>> r117, Function0<Unit> r210) {
        Intrinsics.checkNotNullParameter(r110, GXTemplateKey.GAIAX_TEMPLATE_ID);
        Intrinsics.checkNotNullParameter(r111, "templateData");
        Intrinsics.checkNotNullParameter(r117, "onClickCallback");
        return new IslandWidget(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IslandWidget) == true) goto L8;
        return false;
    L8:
        IslandWidget r101 = (IslandWidget) r100;
        if (Intrinsics.areEqual(this.templateId, r101.templateId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.templateData, r101.templateData) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.isDefault, r101.isDefault) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.view, r101.view) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.inAnimation, r101.inAnimation) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.outAnimation, r101.outAnimation) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.onClickCallback, r101.onClickCallback) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.onCardClickCallback, r101.onCardClickCallback) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.templateId.hashCode() * 31) + this.templateData.hashCode()) * 31;
        Boolean r101 = this.isDefault;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        View r105 = this.view;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        List<? extends TransitionAnimation> r108 = this.inAnimation;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        List<? extends TransitionAnimation> r111 = this.outAnimation;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        JsonObject r114 = this.ext;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (((r113 + r115) * 31) + this.onClickCallback.hashCode()) * 31;
        Function0<Unit> r117 = this.onCardClickCallback;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "IslandWidget(isDefault=" + this.isDefault + ", templateData=" + this.templateData + ", templateId='" + this.templateId + "', ext=" + this.ext + ", inAnimation=" + this.inAnimation + ", outAnimation=" + this.outAnimation + ')';
    }

    public final JsonObject getExt() {
        return this.ext;
    }

    public final List<TransitionAnimation> getInAnimation() {
        return this.inAnimation;
    }

    public final Function0<Unit> getOnCardClickCallback() {
        return this.onCardClickCallback;
    }

    public final Map<String, Function0<Unit>> getOnClickCallback() {
        return this.onClickCallback;
    }

    public final List<TransitionAnimation> getOutAnimation() {
        return this.outAnimation;
    }

    public final Object getTemplateData() {
        return this.templateData;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final View getView() {
        return this.view;
    }

    public final Boolean isDefault() {
        return this.isDefault;
    }

    public IslandWidget(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        String r100 = r110.readString();
        if (r100 != null) goto L5;
        String r101 = "";
    L6:
        String r102 = r110.readString();
        if (r102 != null) goto L9;
        String r103 = "";
    L10:
        Object r104 = r110.readValue(Boolean.TYPE.getClassLoader());
        if ((r104 instanceof Boolean) == false) goto L13;
        Boolean r105 = (Boolean) r104;
    L14:
        View r106 = null;
        Class r107 = Integer.TYPE;
        Object r108 = r110.readValue(r107.getClassLoader());
        if ((r108 instanceof Integer) == false) goto L17;
        Integer r109 = (Integer) r108;
    L17:
        Object r111 = r110.readValue(r107.getClassLoader());
        if ((r111 instanceof Integer) == false) goto L20;
        Integer r112 = (Integer) r111;
    L20:
        Unit r113 = Unit.INSTANCE;
        String r114 = r110.readString();
        if (r114 == null) goto L32;
        List r115 = (List) GsonProtectorUtils.fromJson(new Gson(), r114, new IslandWidget$2$1().getType());
        if (r115 == null) goto L30;
        ArrayList r116 = new ArrayList();
        Iterator r117 = r115.iterator();
    L26:
        if (r117.hasNext() == false) goto L31;
        TransitionAnimation r118 = TransitionAnimation.Companion.fromString((String) r117.next());
        if (r118 == null) goto L26;
        r116.add(r118);
    L31:
        ArrayList r119 = r116;
    L33:
        String r120 = r110.readString();
        if (r120 == null) goto L45;
        List r121 = (List) GsonProtectorUtils.fromJson(new Gson(), r120, new IslandWidget$3$1().getType());
        if (r121 == null) goto L43;
        ArrayList r122 = new ArrayList();
        Iterator r123 = r121.iterator();
    L39:
        if (r123.hasNext() == false) goto L44;
        TransitionAnimation r124 = TransitionAnimation.Companion.fromString((String) r123.next());
        if (r124 == null) goto L39;
        r122.add(r124);
    L44:
        ArrayList r125 = r122;
    L46:
        String r126 = r110.readString();
        if (r126 == null) goto L49;
        JsonObject r127 = (JsonObject) GsonProtectorUtils.fromJson(new Gson(), r126, JsonObject.class);
    L50:
        this(r101, r103, r105, r106, r119, r125, r127, null, null, 384, null);
        return;
    L49:
        r127 = null;
        goto L50
    L43:
        r122 = null;
        goto L44
    L45:
        r125 = null;
        goto L46
    L30:
        r116 = null;
        goto L31
    L32:
        r119 = null;
        goto L33
    L13:
        r105 = null;
        goto L14
    L9:
        r103 = r102;
        goto L10
    L5:
        r101 = r100;
        goto L6
    }

    public final Function0<Unit> findOnViewClickCallbackById(String r100) {
        Intrinsics.checkNotNullParameter(r100, "viewId");
        return this.onClickCallback.get(r100);
    }

    public final void setExt(JsonObject r100) {
        this.ext = r100;
    }

    public final void setInAnimation(List<? extends TransitionAnimation> r100) {
        this.inAnimation = r100;
    }

    public final void setOnCardClickCallback(Function0<Unit> r100) {
        this.onCardClickCallback = r100;
    }

    public final void setOnClickCallback(Map<String, Function0<Unit>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.onClickCallback = r100;
    }

    public final void setOutAnimation(List<? extends TransitionAnimation> r100) {
        this.outAnimation = r100;
    }

    public final void setTemplateData(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.templateData = r100;
    }

    public final void setView(View r100) {
        this.view = r100;
    }

    public final void addOnViewClickCallback(String r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "viewId");
        Intrinsics.checkNotNullParameter(r101, SendEventContainerMethodParamModel.EventKinds.onClick);
        this.onClickCallback.put(r100, r101);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.templateId);
        Object r102 = this.templateData;
        String r103 = null;
        if ((r102 instanceof String) == false) goto L5;
        String r104 = (String) r102;
    L6:
        if (r104 == null) goto L8;
        r100.writeString(r104);
        Unit r105 = Unit.INSTANCE;
    L9:
        if (r105 != null) goto L11;
        r100.writeString(GsonProtectorUtils.toJson(new Gson(), this.templateData));
    L11:
        r100.writeValue(this.isDefault);
        r100.writeValue(null);
        r100.writeValue(null);
        r100.writeString(GsonProtectorUtils.toJson(new Gson(), this.inAnimation));
        r100.writeString(GsonProtectorUtils.toJson(new Gson(), this.outAnimation));
        JsonObject r106 = this.ext;
        if (r106 == null) goto L14;
        r103 = GsonProtectorUtils.toJson(new Gson(), r106);
    L14:
        r100.writeString(r103);
        return;
    L8:
        r105 = null;
        goto L9
    L5:
        r104 = null;
        goto L6
    }

    public IslandWidget(String r100, Object r101, Boolean r102, View r103, List<? extends TransitionAnimation> r104, List<? extends TransitionAnimation> r105, JsonObject r106, Map<String, Function0<Unit>> r107, Function0<Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_TEMPLATE_ID);
        Intrinsics.checkNotNullParameter(r101, "templateData");
        Intrinsics.checkNotNullParameter(r107, "onClickCallback");
        this.templateId = r100;
        this.templateData = r101;
        this.isDefault = r102;
        this.view = r103;
        this.inAnimation = r104;
        this.outAnimation = r105;
        this.ext = r106;
        this.onClickCallback = r107;
        this.onCardClickCallback = r110;
    }

    public /* synthetic */ IslandWidget(String r110, Object r111, Boolean r112, View r113, List r114, List r115, JsonObject r116, Map r210, Function0 r211, int r212, DefaultConstructorMarker r213) {
        if ((r212 & 4) == 0) goto L5;
        Boolean r100 = Boolean.FALSE;
    L7:
        if ((r212 & 8) == 0) goto L9;
        View r101 = null;
    L11:
        if ((r212 & 16) == 0) goto L13;
        List r102 = null;
    L15:
        if ((r212 & 32) == 0) goto L17;
        List r103 = null;
    L19:
        if ((r212 & 64) == 0) goto L21;
        JsonObject r104 = null;
    L23:
        if ((r212 & 128) == 0) goto L25;
        Map r117 = new LinkedHashMap();
    L27:
        if ((r212 & 256) == 0) goto L29;
        Function0 r118 = null;
    L30:
        this(r110, r111, r100, r101, r102, r103, r104, r117, r118);
        return;
    L29:
        r118 = r211;
        goto L30
    L25:
        r117 = r210;
        goto L27
    L21:
        r104 = r116;
        goto L23
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
