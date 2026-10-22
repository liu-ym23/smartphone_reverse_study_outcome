package com.bytedance.ee.bear.drive.biz.permission.adapter;

import com.bytedance.ee.bear.middleground.permission.b;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermissionV2;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001\u0011B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0006\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0010H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/permission/adapter/UserPermissionV2TypeAdapter;", "Lcom/google/gson/JsonSerializer;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocUserPermission;", "Lcom/google/gson/JsonDeserializer;", "<init>", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "serialize", "src", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "Companion", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserPermissionV2TypeAdapter implements JsonSerializer<IDocUserPermission>, JsonDeserializer<IDocUserPermission> {

    public static final class a {
    }

    static {
    }

    public UserPermissionV2TypeAdapter() {
    }

    public final Object deserialize(JsonElement r12, Type r13, JsonDeserializationContext r14) {
        return (IDocUserPermission) new Gson().fromJson(r12, DocUserPermissionV2.class);
    L5:
        th = move-exception;
        tt5.a.d("UserPermissionV2TypeAdapter", th.getMessage());
        return new DocUserPermissionV2(false, 0, null, null, null, null, 0, b.l(), 127, null);
    }

    public final JsonElement serialize(Object r1, Type r2, JsonSerializationContext r3) {
        Gson r4 = new Gson();
        return GsonProtectorUtils.toJsonTree(r4, (IDocUserPermission) r1);
    }
}
