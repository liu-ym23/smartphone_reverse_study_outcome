package com.ss.android.lark.export.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/export/entity/Type;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FLEX_LAYOUT", "ENGINE_VIEW", "EMPTY", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Type extends Enum<Type> {
    public static final a Companion = null;
    public static final Type EMPTY = null;
    public static final Type ENGINE_VIEW = null;
    public static final Type FLEX_LAYOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Type[] f420656a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f420657b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<Type> getEntries() {
        return f420657b;
    }

    static {
        Type r100 = new Type("FLEX_LAYOUT", 0, 0);
        FLEX_LAYOUT = r100;
        Type r101 = new Type("ENGINE_VIEW", 1, 1);
        ENGINE_VIEW = r101;
        Type r102 = new Type("EMPTY", 2, 100);
        EMPTY = r102;
        Type[] r103 = {r100, r101, r102};
        f420656a = r103;
        f420657b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static Type[] values() {
        return (Type[]) f420656a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Type valueOf(String r100) {
        return (Type) r27.a.a(Type.class, r100);
    }

    public Type(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
