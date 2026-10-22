package com.obric.memorydata.sdk.screencapture.rule;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obric.memorydata.sdk.screencapture.event.ScreenEvent;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0006\u0010\u001f\u001a\u00020\nJ\u001c\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H&J!\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\n2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H\u0000¢\u0006\u0002\b(J\u0012\u0010)\u001a\u0004\u0018\u00010\n2\u0006\u0010$\u001a\u00020%H\u0002R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR.\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006+"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/ScreenEventRule;", "Landroid/os/Parcelable;", "<init>", "()V", "eventType", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "getEventType", "()Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "targetPackages", "", "", "getTargetPackages", "()Ljava/util/List;", "setTargetPackages", "(Ljava/util/List;)V", "blackPackages", "getBlackPackages", "setBlackPackages", "blackActivityPrefixes", "", "getBlackActivityPrefixes", "()Ljava/util/Map;", "setBlackActivityPrefixes", "(Ljava/util/Map;)V", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "describeContents", "toJson", "isMatch", "", "event", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isFilter", "pkg", "isFilter$memoryDataSDK_obricRelease", "getCurrentForegroundActivityName", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ScreenEventRule implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<ScreenEvent.EventType, Class<? extends ScreenEventRule>> f397277a = null;

    public static final class a {
    }

    public ScreenEventRule() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        Intrinsics.checkNotNull(new GsonBuilder().registerTypeAdapter(ScreenEventRule.class, new ScreenEventRuleDeserializerTypeAdapter()).create());
        f397277a = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(ScreenEvent.EventType.TOUCH, ScreenTouchEventRule.class), TuplesKt.to(ScreenEvent.EventType.INPUT_METHOD, InputMethodEventRule.class), TuplesKt.to(ScreenEvent.EventType.APP_STATE, AppStateEventRule.class), TuplesKt.to(ScreenEvent.EventType.ACCESSIBILITY, AppAccessibilityEventRule.class)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(GsonProtectorUtils.toJson(new Gson(), this));
    }
}
