package com.obric.assistant.live.gr.island.island.template;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.larus.common.apphost.AppHost;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import pea.f;
import pea.h;
import pea.k;
import pea.l;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\r\u001a\u00020\u0016H\u0017J\b\u0010\u0017\u001a\u00020\u0016H\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006%"}, d2 = {"Lcom/obric/assistant/live/gr/island/island/template/GRExpandedNormalTemplate;", "Lcom/obric/assistant/live/gr/island/island/entity/ITemplateData;", "iconTextInfo", "Lcom/obric/assistant/live/gr/island/island/entity/ExpandedIconTextInfo;", SlcCommonAction.KEY_ACTIONS, "", "Lcom/obric/assistant/live/gr/island/island/entity/ExpandedImageTextActionInfo;", "<init>", "(Lcom/obric/assistant/live/gr/island/island/entity/ExpandedIconTextInfo;Ljava/util/List;)V", "getIconTextInfo", "()Lcom/obric/assistant/live/gr/island/island/entity/ExpandedIconTextInfo;", "setIconTextInfo", "(Lcom/obric/assistant/live/gr/island/island/entity/ExpandedIconTextInfo;)V", "getActions", "()Ljava/util/List;", "setActions", "(Ljava/util/List;)V", "create", "Lcom/obric/assistant/live/gr/island/island/entity/GRIslandWidget;", "isDefault", "", "(Ljava/lang/Boolean;)Lcom/obric/assistant/live/gr/island/island/entity/GRIslandWidget;", "Landroid/os/Bundle;", "getPics", "toJSONObject", "Lorg/json/JSONObject;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GRExpandedNormalTemplate implements l {
    public static final a Companion = null;
    private static final String TEMPLATE_ID = "com.obric.island_assistant:gr_common_expand_template_16";
    private List<h> actions;
    private f iconTextInfo;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GRExpandedNormalTemplate copy$default(GRExpandedNormalTemplate r100, f r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.iconTextInfo;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.actions;
    L9:
        return r100.copy(r101, r102);
    }

    public final f component1() {
        return this.iconTextInfo;
    }

    public final List<h> component2() {
        return this.actions;
    }

    public final GRExpandedNormalTemplate copy(f r100, List<h> r101) {
        Intrinsics.checkNotNullParameter(r100, "iconTextInfo");
        Intrinsics.checkNotNullParameter(r101, SlcCommonAction.KEY_ACTIONS);
        return new GRExpandedNormalTemplate(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GRExpandedNormalTemplate) == true) goto L8;
        return false;
    L8:
        GRExpandedNormalTemplate r101 = (GRExpandedNormalTemplate) r100;
        if (Intrinsics.areEqual(this.iconTextInfo, r101.iconTextInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.actions, r101.actions) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.iconTextInfo.hashCode() * 31) + this.actions.hashCode();
    }

    public String toString() {
        return "GRExpandedNormalTemplate(iconTextInfo=" + this.iconTextInfo + ", actions=" + this.actions + ')';
    }

    @Override // pea.l
    public Bundle getActions() {
        Bundle r100 = new Bundle();
        Iterator<T> r101 = this.actions.iterator();
    L4:
        if (r101.hasNext() == false) goto L15;
        h r102 = (h) r101.next();
        Intent r103 = r102.f528786d;
        if (r102.f528784b != 0) goto L4;
        if (o0.d(r102.f528785c) == false) goto L4;
        if (r103 == null) goto L4;
        AppHost.Companion r104 = AppHost.f326268a;
        Context r105 = r104.getApplication().getApplicationContext();
        String r106 = r102.f528785c;
        if (r106 == null) goto L13;
        int r107 = r106.hashCode();
    L14:
        PendingIntent r108 = PendingIntent.getBroadcast(r105, r107, r103, 201326592);
        Notification.Action r109 = new Notification.Action.Builder(Icon.createWithResource(r104.getApplication().getApplicationContext(), r102.f528789g), r102.f528793k, r108).build();
        r100.putParcelable(r102.f528785c, r109);
        goto L4
    L13:
        r107 = 0;
        goto L14
    L15:
        return r100;
    }

    @Override // pea.l
    public Bundle getPics() {
        Bundle r100 = new Bundle();
        r100.putParcelable(this.iconTextInfo.f528776g.f528750b, Icon.createWithResource(AppHost.f326268a.getApplication().getApplicationContext(), this.iconTextInfo.f528776g.f528751c));
        Iterator<T> r101 = this.actions.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        h r102 = (h) r101.next();
        if (r102.f528784b != 1) goto L4;
        String r103 = r102.f528788f;
        AppHost.Companion r104 = AppHost.f326268a;
        r100.putParcelable(r103, Icon.createWithResource(r104.getApplication().getApplicationContext(), r102.f528789g));
        Integer r105 = r102.f528791i;
        if (r105 == null) goto L4;
        int r106 = r105.intValue();
        r100.putParcelable(r102.f528790h, Icon.createWithResource(r104.getApplication().getApplicationContext(), r106));
        goto L4
    L10:
        return r100;
    }

    @Override // pea.l
    public JSONObject toJSONObject() {
        JSONObject r100 = new JSONObject();
        r100.put("iconTextInfo", this.iconTextInfo.a());
        JSONArray r101 = new JSONArray();
        Iterator<T> r102 = this.actions.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.put(((h) r102.next()).a());
        goto L4
    L6:
        Unit r103 = Unit.INSTANCE;
        r100.put(SlcCommonAction.KEY_ACTIONS, r101);
        return r100;
    }

    public final f getIconTextInfo() {
        return this.iconTextInfo;
    }

    /* JADX INFO: renamed from: getActions, reason: collision with other method in class */
    public final List<h> m8580getActions() {
        return this.actions;
    }

    @Override // pea.l
    public k create(Boolean r100) {
        return new k(TEMPLATE_ID, this, r100);
    }

    public final void setActions(List<h> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.actions = r100;
    }

    public final void setIconTextInfo(f r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.iconTextInfo = r100;
    }

    public GRExpandedNormalTemplate(f r100, List<h> r101) {
        Intrinsics.checkNotNullParameter(r100, "iconTextInfo");
        Intrinsics.checkNotNullParameter(r101, SlcCommonAction.KEY_ACTIONS);
        this.iconTextInfo = r100;
        this.actions = r101;
    }
}
