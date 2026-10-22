package com.ss.android.lark.chat.vo;

import android.text.TextUtils;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;
import com.ss.android.lark.chat.entity.chatter.UserPrivateDescription;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class SenderStatusDisplayHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SenderStatusDisplayHelper f416836a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chat/vo/SenderStatusDisplayHelper$Type;", "", "<init>", "(Ljava/lang/String;I)V", "PRIVATE_DESCRIPTION", "PUBLIC_DESCRIPTION", "HIDE", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        public static final Type HIDE = null;
        public static final Type PRIVATE_DESCRIPTION = null;
        public static final Type PUBLIC_DESCRIPTION = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f416837a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f416838b = null;

        public static EnumEntries<Type> getEntries() {
            return f416838b;
        }

        static {
            Type r100 = new Type("PRIVATE_DESCRIPTION", 0);
            PRIVATE_DESCRIPTION = r100;
            Type r101 = new Type("PUBLIC_DESCRIPTION", 1);
            PUBLIC_DESCRIPTION = r101;
            Type r102 = new Type("HIDE", 2);
            HIDE = r102;
            Type[] r103 = {r100, r101, r102};
            f416837a = r103;
            f416838b = EnumEntriesKt.enumEntries(r103);
        }

        public static Type[] values() {
            return (Type[]) f416837a.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int f416839d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f416840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final UserPrivateDescription f416841b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ChatterDescription f416842c;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.vo.SenderStatusDisplayHelper$a$a, reason: collision with other inner class name */
        public static final class C4878a {
        }

        static {
        }

        public final Type getType() {
            return this.f416840a;
        }

        public a(Type r100, UserPrivateDescription r101, ChatterDescription r102) {
            this.f416840a = r100;
            this.f416841b = r101;
            this.f416842c = r102;
        }
    }

    static {
        f416836a = new SenderStatusDisplayHelper();
    }

    public SenderStatusDisplayHelper() {
    }

    public static a a(ChatterDescription r100) {
        if (r100 != null) goto L4;
    L9:
        boolean r101 = true;
    L11:
        if (r101 == true) goto L13;
        if (r100 == null) goto L18;
        int r102 = a.f416839d;
        Intrinsics.checkNotNullParameter(r100, "publicDescription");
        return new a(Type.PUBLIC_DESCRIPTION, null, r100);
    L18:
        return new a(Type.HIDE, null, null);
    L13:
        return new a(Type.HIDE, null, null);
    L4:
        if (TextUtils.isEmpty(r100.description) == true) goto L6;
    L8:
        r101 = false;
        goto L11
    L6:
        if (r100.type != ChatterDescription.Type.DEFAULT) goto L8;
        goto L8
    }
}
