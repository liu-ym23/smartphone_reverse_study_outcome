package com.bytedance.ee.bear.bitable.uikit.fieldcell;

import com.bytedance.ee.bear.bitable.common.BTJson;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.card.CardViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BitableNativeViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.MobileViewContainerType;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.SubViewType;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.UIExtension;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.GalleryViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridViewData;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.log.Log;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/BitableNativeViewDataParser;", "Lcom/google/gson/JsonDeserializer;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BitableNativeViewData;", "<init>", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "parseUIExtension", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseViewData;", "dataJson", "", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableNativeViewDataParser implements JsonDeserializer<BitableNativeViewData> {

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SubViewType.values().length];
            r0[SubViewType.NativeGrid.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[SubViewType.NativeCard.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[SubViewType.NativeGallery.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[SubViewType.LynxCalendar.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public BitableNativeViewDataParser() {
    }

    public final Object deserialize(JsonElement r10, Type r11, JsonDeserializationContext r12) {
        BitableNativeViewData r13 = new BitableNativeViewData();
        if (r10 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L82;
        JsonObject r14 = r10.getAsJsonObject();
        JsonElement r2 = r14.get("containerType");     // Catch: Throwable -> L80
        Boolean r3 = null;
        if (r2 == null) goto L20;
        String r4 = r2.getAsString();     // Catch: Throwable -> L80
        if (r4 == null) goto L20;
        Enum[] r5 = MobileViewContainerType.values();     // Catch: Throwable -> L80
        int r6 = r5.length;     // Catch: Throwable -> L80
        int r7 = 0;
    L15:
        if (r7 >= r6) goto L20;
        Enum r8 = r5[r7];     // Catch: Throwable -> L80
        if (Intrinsics.areEqual(r8.name(), r4) == true) goto L21;
        r7 = r7 + 1;     // Catch: Throwable -> L80
    L21:
        JsonElement r9 = r14.get("subViewType");     // Catch: Throwable -> L80
        if (r9 == null) goto L40;
        String r16 = r9.getAsString();     // Catch: Throwable -> L80
        if (r16 == null) goto L40;
        SubViewType.Companion.getClass();     // Catch: Throwable -> L80
        Intrinsics.checkNotNullParameter(r16, "value");     // Catch: Throwable -> L80
        SubViewType[] r17 = SubViewType.values();     // Catch: Throwable -> L80
        int r18 = r17.length;     // Catch: Throwable -> L80
        int r19 = 0;
    L26:
        if (r19 >= r18) goto L37;
        SubViewType r20 = r17[r19];     // Catch: Throwable -> L80
        if (Intrinsics.areEqual(r20.getValue(), r16) == false) goto L30;
    L33:
        boolean r21 = true;
    L34:
        if (r21 == true) goto L38;
        r19 = r19 + 1;     // Catch: Throwable -> L80
    L38:
        if (r20 != null) goto L41;
        r20 = SubViewType.Invalid;     // Catch: Throwable -> L80
    L41:
        JsonElement r110 = r14.get("data");     // Catch: Throwable -> L80
        if (r110 == null) goto L45;
        String r111 = r110.toString();     // Catch: Throwable -> L80
        if (r111 == null) goto L45;
    L49:
        JsonElement r22 = r14.get("isClose");     // Catch: Throwable -> L80
        if (r22 == null) goto L52;
        Boolean r23 = Boolean.valueOf(r22.getAsBoolean());     // Catch: Throwable -> L80
    L53:
        if (r111 == null) goto L74;
        if (r20 != null) goto L56;
        int r24 = -1;
    L57:
        if (r24 != 1) goto L59;
        BaseViewData r26 = (BaseViewData) BTJson.c.a(r111, GridViewData.class);     // Catch: Throwable -> L80
    L75:
        JsonElement r112 = r14.get("isOpenView");     // Catch: Throwable -> L80
        if (r112 == null) goto L78;
        r3 = Boolean.valueOf(r112.getAsBoolean());     // Catch: Throwable -> L80
    L78:
        r13.setContainerType(r8);     // Catch: Throwable -> L80
        r13.setSubViewType(r20);     // Catch: Throwable -> L80
        r13.setData(r26);     // Catch: Throwable -> L80
        r13.setDataJson(r111);     // Catch: Throwable -> L80
        r13.setOpenView(r3);     // Catch: Throwable -> L80
        r13.setClose(r23);     // Catch: Throwable -> L80
        goto L82
    L59:
        if (r24 != 2) goto L61;
        r26 = (BaseViewData) BTJson.c.a(r111, CardViewData.class);     // Catch: Throwable -> L80
        goto L75
    L61:
        if (r24 != 3) goto L63;
        r26 = (BaseViewData) BTJson.c.a(r111, GalleryViewData.class);     // Catch: Throwable -> L80
        goto L75
    L63:
        if (r24 != 4) goto L74;
        JSONObject r0 = new JSONObject(r111).optJSONObject("uiExtension");     // Catch: Throwable -> L80
        if (r0 == null) goto L68;
        String r27 = r0.toString();     // Catch: Throwable -> L80
    L69:
        if (r27 == null) goto L74;
        UIExtension r28 = (UIExtension) BTJson.c.a(r27, UIExtension.class);     // Catch: Throwable -> L80
        r26 = new BaseViewData();     // Catch: Throwable -> L80
        r26.setUiExtension(r28);     // Catch: Throwable -> L80
        goto L75
    L68:
        r27 = null;
        goto L69
    L56:
        r24 = b.a[r20.ordinal()];     // Catch: Throwable -> L80
    L74:
        r26 = null;
        goto L75
    L52:
        r23 = null;
    L45:
        JsonElement r113 = r14.get("dataJson");     // Catch: Throwable -> L80
        if (r113 == null) goto L48;
        r111 = r113.getAsString();     // Catch: Throwable -> L80
        goto L49
    L48:
        r111 = null;
        goto L49
    L30:
        if (Intrinsics.areEqual(r20.name(), r16) == true) goto L33;
        r21 = false;
        goto L34
    L37:
        r20 = null;
    L40:
        r20 = null;
    L20:
        r8 = null;
    L80:
        th = move-exception;
        Log.e("BitableNativeViewDataParser", "parse nativeViewData err.", th);
        Unit r114 = Unit.INSTANCE;
    L82:
        return r13;
    L5:
        if (r10.isJsonObject() != true) goto L7;
        r1 = true;
        goto L8
    }
}
