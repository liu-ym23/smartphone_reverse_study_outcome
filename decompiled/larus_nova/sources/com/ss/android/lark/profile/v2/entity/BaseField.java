package com.ss.android.lark.profile.v2.entity;

import com.bytedance.lark.pb.contact.v2.GetUserProfileResponse;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0007\b&\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/BaseField;", "Ljava/io/Serializable;", "<init>", "()V", "key", "", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "name", "getName", "setName", "tips", "getTips", "setTips", "fieldType", "", "getFieldType", "()I", "setFieldType", "(I)V", "Companion", "FieldType", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseField implements Serializable {
    public static final a Companion = null;
    public static final int FIELD_TYPE_ALIAS_AND_MEMO = 104;
    public static final int FIELD_TYPE_C_ALIAS = 50;
    public static final int FIELD_TYPE_C_DESCRIPTION = 51;
    public static final int FIELD_TYPE_LINK = 2;
    public static final int FIELD_TYPE_LINK_LIST = 4;
    public static final int FIELD_TYPE_MEMO_DESCRIPTION = 105;
    public static final int FIELD_TYPE_NAME_CARD_PHONE = 500;
    public static final int FIELD_TYPE_S_DEPARTMENT = 100;
    public static final int FIELD_TYPE_S_FRIEND_LINK = 102;
    public static final int FIELD_TYPE_S_PHONE_NUMBER = 101;
    public static final int FIELD_TYPE_TEXT = 1;
    public static final int FIELD_TYPE_TEXT_LIST = 3;
    public static final int FIELD_TYPE_UNKNOWN = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f438853a = 0;
    private int fieldType;
    private String key;
    private String name;
    private String tips;

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/BaseField$FieldType;", "", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface FieldType {
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        f438853a = GetUserProfileResponse.Field.FieldType.CUSTOM_PHONE.getValue();
    }

    public BaseField() {
        this.key = "";
    }

    public static final /* synthetic */ int access$getFIELD_TYPE_CUSTOM_PHONE$cp() {
        return f438853a;
    }

    public final int getFieldType() {
        return this.fieldType;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTips() {
        return this.tips;
    }

    public final void setFieldType(int r100) {
        this.fieldType = r100;
    }

    public final void setKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.key = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setTips(String r100) {
        this.tips = r100;
    }
}
