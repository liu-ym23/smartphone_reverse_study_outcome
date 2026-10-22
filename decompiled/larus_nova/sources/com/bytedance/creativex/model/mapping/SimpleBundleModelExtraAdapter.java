package com.bytedance.creativex.model.mapping;

import android.os.Bundle;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.Serializable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/creativex/model/mapping/SimpleBundleModelExtraAdapter;", "Lcom/google/gson/TypeAdapter;", "Landroid/os/Bundle;", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class SimpleBundleModelExtraAdapter extends TypeAdapter<Bundle> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f204230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f204231b;

    @Override // com.google.gson.TypeAdapter
    public final Bundle read(JsonReader r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        Bundle r101 = new Bundle(SimpleBundleModelExtraAdapter.class.getClassLoader());
        r100.beginObject();
    L4:
        if (r100.hasNext() == false) goto L43;
        String r102 = r100.nextName();
        Class<?> r103 = this.f204231b.get(r102);
        Object r104 = GsonProtectorUtils.fromJson(this.f204230a, r100.nextString(), r103);
        if (r104 == null) goto L7;
        if ((r104 instanceof Parcelable) == true) goto L10;
        if ((r104 instanceof Serializable) == true) goto L13;
        if ((r104 instanceof Byte) == true) goto L16;
        if ((r104 instanceof Character) == true) goto L19;
        if ((r104 instanceof Boolean) == true) goto L22;
        if ((r104 instanceof Integer) == true) goto L25;
        if ((r104 instanceof Short) == true) goto L28;
        if ((r104 instanceof Long) == true) goto L31;
        if ((r104 instanceof Float) == true) goto L34;
        if ((r104 instanceof Double) == true) goto L37;
        if ((r104 instanceof String) == false) goto L42;
        r101.putString(r102, (String) r104);
        goto L4
    L42:
        throw new IllegalStateException("type not supported yet".toString());
    L37:
        r101.putDouble(r102, ((Number) r104).doubleValue());
        goto L4
    L34:
        r101.putFloat(r102, ((Number) r104).floatValue());
        goto L4
    L31:
        r101.putLong(r102, ((Number) r104).longValue());
        goto L4
    L28:
        r101.putShort(r102, ((Number) r104).shortValue());
        goto L4
    L25:
        r101.putInt(r102, ((Number) r104).intValue());
        goto L4
    L22:
        r101.putBoolean(r102, ((Boolean) r104).booleanValue());
        goto L4
    L19:
        r101.putChar(r102, ((Character) r104).charValue());
        goto L4
    L16:
        r101.putByte(r102, ((Number) r104).byteValue());
        goto L4
    L13:
        r101.putSerializable(r102, (Serializable) r104);
        goto L4
    L10:
        r101.putParcelable(r102, (Parcelable) r104);
        goto L4
    L7:
        r101.putSerializable(r102, (Serializable) r104);
        goto L4
    L43:
        r100.endObject();
        return r101;
    }

    public SimpleBundleModelExtraAdapter(Gson r100, InitialModelExtraMapping r101) {
        Intrinsics.checkNotNullParameter(r100, "gson");
        Intrinsics.checkNotNullParameter(r101, "mapping");
        this.f204230a = r100;
        this.f204231b = r101;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, Bundle r101) {
        Bundle r102 = r101;
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        Intrinsics.checkNotNullParameter(r102, "bundle");
        r100.beginObject();
        if (r102.getClassLoader() != null) goto L5;
        r102.setClassLoader(SimpleBundleModelExtraAdapter.class.getClassLoader());
    L5:
        Iterator<T> r103 = r102.keySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        String r104 = (String) r103.next();
        Class<?> r105 = this.f204231b.get(r104);
        Object r106 = r102.get(r104);
        r100.name(r104);
        r100.value(GsonProtectorUtils.toJson(this.f204230a, r106, r105));
        goto L7
    L9:
        r100.endObject();
    }
}
