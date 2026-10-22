package com.obric.capabilitykit.entity;

import android.net.Uri;
import android.os.Parcel;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obric.capabilitykit.common.e;
import com.obric.capabilitykit.common.f;
import com.obric.capabilitykit.common.g;
import com.obric.capabilitykit.common.h;
import com.obric.capabilitykit.common.i;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ExtraEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.meta.MetaValue;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0003H\u0007\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0007\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0005H\u0007\"\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u001a\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AppEntity;", "", "toJson", "Lcom/obric/capabilitykit/entity/app/ExtraEntity;", "toJsonKeepTimeStamp", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "Lcom/google/gson/Gson;", "entityGson", "Lcom/google/gson/Gson;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/google/gson/Gson;", "entityKeepTimeStampGson", "b", "capabilitykitcommon_release"}, k = 2, mv = {1, 7, 1})
public final class EntityExtKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f396198a = null;
    private static final Gson entityGson = null;
    private static final Gson entityKeepTimeStampGson = null;

    static {
        Gson r100 = new GsonBuilder().registerTypeAdapter(Uri.class, new UriTypeAdapter()).registerTypeAdapterFactory(new ExtraTypeAdapterFactory()).registerTypeAdapterFactory(new g()).registerTypeAdapter(AppEntity.class, new e()).registerTypeAdapter(AppEntity.class, new f()).registerTypeAdapter(MemoryEntity.class, new e()).registerTypeAdapter(MemoryEntity.class, new f()).registerTypeAdapter(MetaValue.class, new i()).registerTypeAdapter(MetaValue.class, new h()).create();
        Intrinsics.checkNotNull(r100);
        entityGson = r100;
        Gson r101 = new GsonBuilder().registerTypeAdapter(Uri.class, new UriTypeAdapter()).registerTypeAdapterFactory(new ExtraTypeAdapterFactory()).registerTypeAdapterFactory(new g()).create();
        Intrinsics.checkNotNull(r101);
        f396198a = r101;
        Gson r102 = new GsonBuilder().registerTypeAdapter(Uri.class, new UriTypeAdapter()).registerTypeAdapterFactory(new ExtraTypeAdapterFactory()).create();
        Intrinsics.checkNotNull(r102);
        entityKeepTimeStampGson = r102;
    }

    public static final Gson a() {
        return entityGson;
    }

    public static final Gson b() {
        return entityKeepTimeStampGson;
    }

    public static final boolean c(Object r100) {
        if (r100 != null) goto L6;
        return true;
    L6:
        if ((r100 instanceof Integer) == false) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L17;
        boolean r104 = true;
    L18:
        if (r104 == false) goto L20;
        boolean r105 = true;
    L21:
        if (r105 == false) goto L23;
        boolean r106 = true;
    L24:
        if (r106 == false) goto L26;
        boolean r107 = true;
    L27:
        if (r107 == false) goto L29;
        boolean r108 = true;
    L30:
        if (r108 == false) goto L33;
        return true;
    L33:
        if ((r100 instanceof Uri) == false) goto L36;
        return true;
    L36:
        if ((r100 instanceof MetaValue) == false) goto L39;
        return true;
    L39:
        if ((r100 instanceof List) == false) goto L52;
        Iterable r109 = (Iterable) r100;
        if ((r109 instanceof Collection) == true) goto L43;
    L45:
        Iterator r110 = r109.iterator();
    L47:
        if (r110.hasNext() == false) goto L81;
        if (c(r110.next()) == true) goto L47;
    L66:
        return false;
    L81:
        return true;
    L43:
        if (((Collection) r109).isEmpty() == false) goto L45;
        return true;
    L52:
        if ((r100 instanceof Map) == false) goto L66;
        Map r111 = (Map) r100;
        if (r111.isEmpty() == true) goto L80;
        Iterator r112 = r111.entrySet().iterator();
    L58:
        if (r112.hasNext() == false) goto L82;
        Map.Entry r113 = (Map.Entry) r112.next();
        if (c(r113.getKey()) == true) goto L62;
    L64:
        boolean r114 = false;
    L65:
        if (r114 == true) goto L58;
    L62:
        if (c(r113.getValue()) == false) goto L64;
        r114 = true;
        goto L65
    L82:
        return true;
    L80:
        return true;
    L29:
        r108 = r100 instanceof String;
        goto L30
    L26:
        r107 = r100 instanceof Character;
        goto L27
    L23:
        r106 = r100 instanceof Boolean;
        goto L24
    L20:
        r105 = r100 instanceof Byte;
        goto L21
    L17:
        r104 = r100 instanceof Short;
        goto L18
    L14:
        r103 = r100 instanceof Long;
        goto L15
    L11:
        r102 = r100 instanceof Float;
        goto L12
    L8:
        r101 = r100 instanceof Double;
        goto L9
    }

    public static final boolean d(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.readInt() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static final String e(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.readString();
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }

    public static final String toJson(AppEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return GsonProtectorUtils.toJson(f396198a, r100);
    }

    public static final String toJson(ExtraEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return GsonProtectorUtils.toJson(f396198a, r100);
    }

    public static final String toJson(MetaValue r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return GsonProtectorUtils.toJson(f396198a, r100);
    }

    public static final String toJsonKeepTimeStamp(AppEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return GsonProtectorUtils.toJson(entityKeepTimeStampGson, r100);
    }
}
