package com.ss.android.lark.lynxkit.xbridge;

import androidx.camera.video.AudioStats;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u001a\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J$\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0015H\u0002¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/lynxkit/xbridge/LynxReadableMapConverter;", "", "<init>", "()V", "toMap", "", "", "mapData", "Lcom/lynx/react/bridge/ReadableMap;", "toList", "", "arrayData", "Lcom/lynx/react/bridge/ReadableArray;", "readMapValue", "key", "readArrayValue", "index", "", "readNumber", "", "readInt", "Lkotlin/Function0;", "readDouble", "", "lark-lynx-xbridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxReadableMapConverter {
    public static final LynxReadableMapConverter INSTANCE = null;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[ReadableType.values().length];
            r100[ReadableType.Null.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r100[ReadableType.Boolean.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r100[ReadableType.Int.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r100[ReadableType.Long.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r100[ReadableType.Number.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r100[ReadableType.String.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r100[ReadableType.Map.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r100[ReadableType.Array.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r100[ReadableType.ByteArray.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r100[ReadableType.PiperData.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            $EnumSwitchMapping$0 = r100;
        }
    }

    static {
        INSTANCE = new LynxReadableMapConverter();
    }

    private LynxReadableMapConverter() {
    }

    private final List<Object> toList(ReadableArray r100) {
        if (r100 == null) goto L4;
        ArrayList r101 = new ArrayList(r100.size());
        int r102 = r100.size();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L8;
        r101.add(INSTANCE.readArrayValue(r100, r103));
        r103 = r103 + 1;
        goto L6
    L8:
        return r101;
    L4:
        return CollectionsKt.emptyList();
    }

    public final Map<String, Object> toMap(ReadableMap r100) {
        if (r100 == null) goto L4;
        LinkedHashMap r101 = new LinkedHashMap();
        ReadableMapKeySetIterator r102 = r100.keySetIterator();
    L7:
        if (r102.hasNextKey() == false) goto L9;
        String r103 = r102.nextKey();
        Intrinsics.checkNotNull(r103);
        r101.put(r103, INSTANCE.readMapValue(r100, r103));
        goto L7
    L9:
        return r101;
    L4:
        return MapsKt.emptyMap();
    }

    private final Object readArrayValue(final ReadableArray r100, final int r101) {
        ReadableType r102 = r100.getType(r101);
        if (r102 != null) goto L5;
        int r103 = -1;
    L7:
        switch(r103) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L23;
            case 8: goto L22;
            case 9: goto L21;
            case 10: goto L20;
            default: goto L19;
        };
    L19:
        return null;
    L20:
        return r100.getPiperData(r101);
    L21:
        return r100.getByteArray(r101);
    L22:
        return toList(r100.getArray(r101));
    L23:
        return toMap(r100.getMap(r101));
    L24:
        return r100.getString(r101);
    L25:
        return readNumber(new AnonymousClass1(r100, r101), new AnonymousClass2(r100, r101));
    L26:
        return Long.valueOf(r100.getLong(r101));
    L27:
        return Integer.valueOf(r100.getInt(r101));
    L18:
        return Boolean.valueOf(r100.getBoolean(r101));
    L5:
        r103 = WhenMappings.$EnumSwitchMapping$0[r102.ordinal()];
        goto L7
    }

    private final Object readMapValue(final ReadableMap r100, final String r101) {
        ReadableType r102 = r100.getType(r101);
        if (r102 != null) goto L5;
        int r103 = -1;
    L7:
        switch(r103) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L23;
            case 8: goto L22;
            case 9: goto L21;
            case 10: goto L20;
            default: goto L19;
        };
    L19:
        return null;
    L20:
        return r100.getPiperData(r101);
    L21:
        return r100.getByteArray(r101);
    L22:
        return toList(r100.getArray(r101));
    L23:
        return toMap(r100.getMap(r101));
    L24:
        return r100.getString(r101);
    L25:
        return readNumber(new C119211(r100, r101), new C119222(r100, r101));
    L26:
        return Long.valueOf(r100.getLong(r101));
    L27:
        return Integer.valueOf(r100.getInt(r101));
    L18:
        return Boolean.valueOf(r100.getBoolean(r101));
    L5:
        r103 = WhenMappings.$EnumSwitchMapping$0[r102.ordinal()];
        goto L7
    }

    private final Number readNumber(Function0<Integer> r100, Function0<Double> r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(Integer.valueOf(r100.invoke().intValue()));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r103) == false) goto L9;
        r103 = 0;
    L9:
        int r104 = ((Number) r103).intValue();
        Object r105 = Result.m9449constructorimpl(Double.valueOf(r101.invoke().doubleValue()));     // Catch: Throwable -> L12
    L14:
        Double r106 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        if (Result.m9455isFailureimpl(r105) == false) goto L17;
        r105 = r106;
    L17:
        double r107 = ((Number) r105).doubleValue();
        if (Double.compare(r104, r107) == 0) goto L20;
        long r108 = (long) r107;
        if (Double.compare(r108, r107) != 0) goto L26;
        return Long.valueOf(r108);
    L26:
        return Double.valueOf(r107);
    L20:
        return Integer.valueOf(r104);
    L12:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L4:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
