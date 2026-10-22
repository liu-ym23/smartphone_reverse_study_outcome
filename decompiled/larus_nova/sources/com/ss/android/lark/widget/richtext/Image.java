package com.ss.android.lark.widget.richtext;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import okio.ByteString;

/* JADX INFO: loaded from: classes38.dex */
public class Image implements Serializable {
    private static final long serialVersionUID = -2514439118477067808L;
    private File cache;

    @JSONField(serialize = false)
    private ByteString crypto;
    private String fsUnit;
    private int height;
    private boolean isAvatar;
    private String key;
    private ResourceCleanScene resourceCleanScene;
    boolean resourceIsCleaned;
    private String token;
    private Type type;
    private List<String> urls;
    private int width;

    public static final enum Type extends Enum<Type> {
        public static final Type ENCRYPTED = null;
        public static final Type NORMAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f448191a = null;
        private int value;

        static {
            Type r100 = new Type(EffectConstants.NORMAL, 0, 1);
            NORMAL = r100;
            Type r101 = new Type("ENCRYPTED", 1, 2);
            ENCRYPTED = r101;
            f448191a = new Type[]{r100, r101};
        }

        public static Type[] values() {
            return (Type[]) f448191a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Type forNumber(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return ENCRYPTED;
        L11:
            return NORMAL;
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public static Type valueOf(int r100) {
            return forNumber(r100);
        }

        public Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public String getFirstUrl() {
        if (CollectionUtils.isNotEmpty(this.urls) == true) goto L5;
        return "";
    L5:
        return (String) ListProtector.get(this.urls, 0);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.key, this.urls, Integer.valueOf(this.width), Integer.valueOf(this.height), Boolean.valueOf(this.isAvatar), this.token, this.type, this.cache, this.crypto, this.fsUnit, Boolean.valueOf(this.resourceIsCleaned), this.resourceCleanScene});
    }

    public String toString() {
        if (this.crypto == null) goto L7;
        return "key:" + this.key + " fsUnit:" + this.fsUnit + " crypto size:" + this.crypto.size();
    L7:
        return "key:" + this.key + " fsUnit:" + this.fsUnit + " crypto is null";
    }

    public Image() {
        this.key = "";
        this.urls = new ArrayList();
        this.type = Type.ENCRYPTED;
        this.resourceIsCleaned = false;
        this.resourceCleanScene = null;
    }

    public File getCache() {
        return this.cache;
    }

    public ByteString getCrypto() {
        return this.crypto;
    }

    public String getFsUnit() {
        return this.fsUnit;
    }

    public int getHeight() {
        return this.height;
    }

    public String getKey() {
        return this.key;
    }

    public ResourceCleanScene getResourceCleanScene() {
        return this.resourceCleanScene;
    }

    public String getToken() {
        return this.token;
    }

    public Type getType() {
        return this.type;
    }

    public List<String> getUrls() {
        return this.urls;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isResourceIsCleaned() {
        return this.resourceIsCleaned;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L37:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L37;
        Image r101 = (Image) r100;
        if (this.width == r101.width) goto L13;
    L35:
        return false;
    L13:
        if (this.height != r101.height) goto L35;
        if (this.isAvatar != r101.isAvatar) goto L35;
        if (this.resourceIsCleaned != r101.resourceIsCleaned) goto L35;
        if (Objects.equals(this.key, r101.key) == false) goto L35;
        if (Objects.equals(this.urls, r101.urls) == false) goto L35;
        if (Objects.equals(this.token, r101.token) == false) goto L35;
        if (this.type != r101.type) goto L35;
        if (Objects.equals(this.cache, r101.cache) == false) goto L35;
        if (Objects.equals(this.crypto, r101.crypto) == false) goto L35;
        if (Objects.equals(this.fsUnit, r101.fsUnit) == false) goto L35;
        if (this.resourceCleanScene != r101.resourceCleanScene) goto L35;
        return true;
    }

    public void setCache(File r100) {
        this.cache = r100;
    }

    public void setCrypto(ByteString r100) {
        this.crypto = r100;
    }

    public void setFsUnit(String r100) {
        this.fsUnit = r100;
    }

    public void setHeight(int r100) {
        this.height = r100;
    }

    public void setKey(String r100) {
        this.key = r100;
    }

    public void setResourceCleanScene(ResourceCleanScene r100) {
        this.resourceCleanScene = r100;
    }

    public void setResourceIsCleaned(boolean r100) {
        this.resourceIsCleaned = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setType(Type r100) {
        this.type = r100;
    }

    public void setUrls(List<String> r100) {
        this.urls = r100;
    }

    public void setWidth(int r100) {
        this.width = r100;
    }
}
