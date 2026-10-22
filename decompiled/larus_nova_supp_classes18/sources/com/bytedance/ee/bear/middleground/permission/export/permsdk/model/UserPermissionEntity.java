package com.bytedance.ee.bear.middleground.permission.export.permsdk.model;

import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B;\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012&\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR:\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/UserPermissionEntity;", "", "userPermission", "optionalUserPermMap", "Ljava/util/HashMap;", "", "Ljava/io/Serializable;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/lang/Object;Ljava/util/HashMap;)V", "getUserPermission", "()Ljava/lang/Object;", "setUserPermission", "(Ljava/lang/Object;)V", "getOptionalUserPermMap", "()Ljava/util/HashMap;", "setOptionalUserPermMap", "(Ljava/util/HashMap;)V", "Companion", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserPermissionEntity {
    public static final a Companion = null;
    public static final String IS_OWNER = "IS_OWNER";
    private HashMap<String, Serializable> optionalUserPermMap;
    private Object userPermission;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final HashMap<String, Serializable> getOptionalUserPermMap() {
        return this.optionalUserPermMap;
    }

    public final Object getUserPermission() {
        return this.userPermission;
    }

    public final void setOptionalUserPermMap(HashMap<String, Serializable> r1) {
        this.optionalUserPermMap = r1;
    }

    public final void setUserPermission(Object r1) {
        this.userPermission = r1;
    }

    public UserPermissionEntity(Object r1, HashMap<String, Serializable> r2) {
        this.userPermission = r1;
        this.optionalUserPermMap = r2;
    }
}
