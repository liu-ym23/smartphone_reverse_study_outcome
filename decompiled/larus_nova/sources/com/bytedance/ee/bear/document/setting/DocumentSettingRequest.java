package com.bytedance.ee.bear.document.setting;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/document/setting/DocumentSettingRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "permissionType", "", "getPermissionType", "()Ljava/lang/Integer;", "setPermissionType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "properties", "Lcom/bytedance/ee/bear/document/setting/DocumentSettingRequest$Property;", "getProperties", "()Lcom/bytedance/ee/bear/document/setting/DocumentSettingRequest$Property;", "setProperties", "(Lcom/bytedance/ee/bear/document/setting/DocumentSettingRequest$Property;)V", "Companion", "Property", "docs-document-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocumentSettingRequest implements NonProguard {
    public static final int ACCESS_ANY_ONE = 2;
    public static final int ACCESS_ONLY_INVITED = 1;
    public static final a Companion = null;

    @JSONField(name = "permission_type")
    private Integer permissionType;
    private Property properties;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/document/setting/DocumentSettingRequest$Property;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "initialSetting", "", "getInitialSetting", "()Z", "setInitialSetting", "(Z)V", "allowShareOutside", "getAllowShareOutside", "setAllowShareOutside", "docs-document-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Property implements NonProguard {

        @JSONField(name = "allow_share_outside")
        private boolean allowShareOutside;

        @JSONField(name = "initial_setting")
        private boolean initialSetting;

        public Property() {
            this.initialSetting = true;
            this.allowShareOutside = true;
        }

        public final boolean getAllowShareOutside() {
            return this.allowShareOutside;
        }

        public final boolean getInitialSetting() {
            return this.initialSetting;
        }

        public final void setAllowShareOutside(boolean r100) {
            this.allowShareOutside = r100;
        }

        public final void setInitialSetting(boolean r100) {
            this.initialSetting = r100;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public DocumentSettingRequest() {
    }

    public final Integer getPermissionType() {
        return this.permissionType;
    }

    public final Property getProperties() {
        return this.properties;
    }

    public final void setPermissionType(Integer r100) {
        this.permissionType = r100;
    }

    public final void setProperties(Property r100) {
        this.properties = r100;
    }
}
