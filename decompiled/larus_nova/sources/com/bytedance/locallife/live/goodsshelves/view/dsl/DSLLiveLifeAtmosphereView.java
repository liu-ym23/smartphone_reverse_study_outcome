package com.bytedance.locallife.live.goodsshelves.view.dsl;

import android.content.Context;
import android.util.AttributeSet;
import com.alibaba.gaiax.api.GXICustomViewBindData;
import com.bytedance.locallife.live.view.LiveLifeAtmosphereAnimView;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import qv6.e;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/view/dsl/DSLLiveLifeAtmosphereView;", "Lcom/bytedance/locallife/live/view/LiveLifeAtmosphereAnimView;", "Lcom/alibaba/gaiax/api/GXICustomViewBindData;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onBindData", "", "data", "Lorg/json/JSONObject;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class DSLLiveLifeAtmosphereView extends LiveLifeAtmosphereAnimView implements GXICustomViewBindData {
    public DSLLiveLifeAtmosphereView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public DSLLiveLifeAtmosphereView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    @Override // com.alibaba.gaiax.api.GXICustomViewBindData, com.alibaba.gaiax.render.view.GXIViewBindData
    public void onBindData(JSONObject r110) {
        if (r110 != null) goto L49;
        Object r111 = null;
    L9:
        if ((r111 instanceof JSONObject) == false) goto L11;
        JSONObject r112 = (JSONObject) r111;     // Catch: Exception -> L5
    L12:
        if (r112 != null) goto L14;
        return;
    L14:
        int r100 = r112.optInt("atmosphere_type", -1);     // Catch: Exception -> L5
        if (r100 <= 0) goto L17;
        changeAnimType(r100);     // Catch: Exception -> L5
    L17:
        int r101 = r112.optInt("num", -1);     // Catch: Exception -> L5
        if (r101 > 0) goto L20;
    L24:
        String r102 = r112.optString("text", "");     // Catch: Exception -> L5
        if (r102.length() <= 0) goto L27;
        boolean r103 = true;
    L28:
        if (r103 == false) goto L30;
        setText(r102);     // Catch: Exception -> L5
    L30:
        JSONObject r104 = r112.optJSONObject("icon");     // Catch: Exception -> L5
        if (r104 == null) goto L33;
        String r105 = r104.optString("uri");     // Catch: Exception -> L5
    L34:
        JSONObject r113 = r112.optJSONObject("icon");     // Catch: Exception -> L5
        if (r113 == null) goto L44;
        JSONArray r114 = r113.optJSONArray(ScoreTags.STAR_URL_LIST);     // Catch: Exception -> L5
        if (r114 == null) goto L44;
        ArrayList r106 = new ArrayList();     // Catch: Exception -> L5
        int r107 = r114.length();     // Catch: Exception -> L5
        int r108 = 0;
    L39:
        if (r108 >= r107) goto L45;
        if ((r114.get(r108) instanceof String) == false) goto L43;
        Object r109 = r114.get(r108);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L5
        r106.add((String) r109);     // Catch: Exception -> L5
    L43:
        r108 = r108 + 1;     // Catch: Exception -> L5
    L45:
        setIcon(r105, r106);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.a("live_life_dsl_shelf_error", MapsKt.mapOf(new Pair[]{TuplesKt.to("error_code", "-89"), TuplesKt.to("error_msg", String.valueOf(e.getMessage()))}), true, null);
        return;
    L44:
        r106 = null;
        goto L45
    L33:
        r105 = null;
        goto L34
    L27:
        r103 = false;
        goto L28
    L20:
        if (r112.optBoolean("is_update", false) == true) goto L22;
        boolean r115 = true;
    L23:
        setNum(r101, r115);     // Catch: Exception -> L5
        goto L24
    L22:
        r115 = false;
        goto L23
    L11:
        r112 = null;
        goto L12
    L49:
        r111 = r110.opt("value");     // Catch: Exception -> L5
        goto L9
    }

    public DSLLiveLifeAtmosphereView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setScaleX(0.8f);
        setScaleY(0.8f);
        setPivotX(0.0f);
        setPivotY(0.0f);
    }

    public /* synthetic */ DSLLiveLifeAtmosphereView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
