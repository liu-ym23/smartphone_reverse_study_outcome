package com.bytedance.ies.argus.plugin;

import com.bytedance.ies.argus.bean.q;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/argus/plugin/SecurePluginType;", "", "Lcom/bytedance/ies/argus/bean/q;", "", "stringValue", "Ljava/lang/String;", "getStringValue", "()Ljava/lang/String;", "Lcom/bytedance/ies/argus/plugin/SecurePluginInstanceType;", "instanceType", "Lcom/bytedance/ies/argus/plugin/SecurePluginInstanceType;", "getInstanceType", "()Lcom/bytedance/ies/argus/plugin/SecurePluginInstanceType;", "SEC_LINK", "TTMACHINE", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum SecurePluginType extends Enum<SecurePluginType> implements q {
    public static final SecurePluginType SEC_LINK = null;
    public static final SecurePluginType TTMACHINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SecurePluginType[] f246080a = null;
    private final SecurePluginInstanceType instanceType;
    private final String stringValue;

    public static SecurePluginType valueOf(String r100) {
        return (SecurePluginType) r27.a.a(SecurePluginType.class, r100);
    }

    public static SecurePluginType[] values() {
        return (SecurePluginType[]) f246080a.clone();
    }

    static {
        SecurePluginType r100 = new SecurePluginType("SEC_LINK", 0, "sec_link", SecurePluginInstanceType.CONTAINER);
        SEC_LINK = r100;
        SecurePluginType r101 = new SecurePluginType("TTMACHINE", 1, "ttmachine", SecurePluginInstanceType.GLOBAL);
        TTMACHINE = r101;
        f246080a = new SecurePluginType[]{r100, r101};
    }

    public final SecurePluginInstanceType getInstanceType() {
        return this.instanceType;
    }

    @Override // com.bytedance.ies.argus.bean.q
    public String getStringValue() {
        return this.stringValue;
    }

    public SecurePluginType(String r100, int r101, String r102, SecurePluginInstanceType r103) {
        super(r100, r101);
        this.stringValue = r102;
        this.instanceType = r103;
    }
}
