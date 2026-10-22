package yt5;

import com.bytedance.ee.bear.document.setting.DocumentSettingViewModel;
import com.bytedance.ee.permission.sdk.define.IPermissionApi$ERequestMethod;
import com.bytedance.ee.permission.sdk.define.value.TypeExternalAccess;
import com.bytedance.ee.permission.sdk.define.value.TypeLinkShare;
import com.bytedance.ee.permission.sdk.define.value.TypePermissionScope;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements xt5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f569139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f569140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TypePermissionScope f569141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TypeExternalAccess f569142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TypeLinkShare f569143e;

    @Override // xt5.b
    public final String a() {
        return "/space/api/suite/permission/public/update.v5/";
    }

    @Override // xt5.b
    public final Map<String, Serializable> b() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("token", this.f569139a);
        r100.put("type", Integer.valueOf(this.f569140b));
        TypeExternalAccess r101 = this.f569142d;
        boolean r102 = true;
        if (r101 == TypeExternalAccess.INVALID) goto L5;
        boolean r103 = true;
    L6:
        TypePermissionScope r104 = null;
        if (r103 == true) goto L10;
        r101 = null;
    L10:
        if (r101 == null) goto L12;
        Serializable r105 = (Serializable) r100.put("external_access_entity", r101.m8356getTypeValue());
    L12:
        TypeLinkShare r106 = this.f569143e;
        if (r106 == TypeLinkShare.INVALID) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == true) goto L20;
        r106 = null;
    L20:
        if (r106 == null) goto L22;
        Serializable r108 = (Serializable) r100.put("link_share_entity", r106.m8357getTypeValue());
    L22:
        TypePermissionScope r109 = this.f569141c;
        if (r109 != TypePermissionScope.INVALID) goto L26;
        r102 = false;
    L26:
        if (r102 == false) goto L28;
        r104 = r109;
    L28:
        if (r104 == null) goto L30;
        JSONObject r110 = new JSONObject();
        r110.putOpt("external_access_switch", r104.m8358getTypeValue());
        r110.putOpt("link_share_entity", r104.m8358getTypeValue());
        Unit r111 = Unit.INSTANCE;
        r100.put(DocumentSettingViewModel.KEY_ACCESS_PERM_TYPE, r110.toString());
    L30:
        return r100;
    L15:
        r107 = false;
        goto L16
    L5:
        r103 = false;
        goto L6
    }

    @Override // xt5.b
    public final IPermissionApi$ERequestMethod getMethod() {
        return IPermissionApi$ERequestMethod.POST;
    }

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        this.f569139a = r100;
        this.f569140b = 3;
        this.f569141c = TypePermissionScope.INVALID;
        this.f569142d = TypeExternalAccess.INVALID;
        this.f569143e = TypeLinkShare.INVALID;
    }
}
