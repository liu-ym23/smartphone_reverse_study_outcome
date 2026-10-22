package com.bytedance.caijing.sdk.infra.base.api.plugin.container.xelement.keyboard;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/xelement/keyboard/Type;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, CardAdapter.TEXT, "ICON", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public final enum Type extends Enum<Type> {
    public static final a Companion = null;
    public static final Type ICON = null;
    public static final Type TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Type[] f202241a = null;

    public static final class a {
        public a() {
        }
    }

    public static Type valueOf(String r100) {
        return (Type) r27.a.a(Type.class, r100);
    }

    public static Type[] values() {
        return (Type[]) f202241a.clone();
    }

    static {
        Type r100 = new Type(CardAdapter.TEXT, 0);
        TEXT = r100;
        Type r101 = new Type("ICON", 1);
        ICON = r101;
        f202241a = new Type[]{r100, r101};
        Companion = new a();
    }

    public Type(String r100, int r101) {
        super(r100, r101);
    }
}
