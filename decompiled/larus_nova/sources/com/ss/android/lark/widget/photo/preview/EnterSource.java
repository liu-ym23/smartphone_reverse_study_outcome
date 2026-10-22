package com.ss.android.lark.widget.photo.preview;

import com.larus.network.http.ServiceType;
import com.ss.android.lark.chat.entity.message.Message;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/widget/photo/preview/EnterSource;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Favorite", "Mark", ServiceType.IM, "Companion", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EnterSource extends Enum<EnterSource> {
    public static final a Companion = null;
    public static final EnterSource Favorite = null;
    public static final EnterSource Mark = null;
    public static final EnterSource Message = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EnterSource[] f446495a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f446496b = null;
    private final int value;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.widget.photo.preview.EnterSource$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C5407a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f446497a = null;

            static {
                int[] r100 = new int[Message.SourceType.values().length];
                r100[Message.SourceType.TYPE_FROM_FAVORITE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[Message.SourceType.TYPE_FROM_FLAG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f446497a = r100;
            }
        }

        public a() {
        }

        public static EnterSource a(Message.SourceType r100) {
            if (r100 != null) goto L4;
            int r101 = -1;
        L6:
            if (r101 == 1) goto L12;
            if (r101 == 2) goto L14;
            return EnterSource.Message;
        L14:
            return EnterSource.Mark;
        L12:
            return EnterSource.Favorite;
        L4:
            r101 = C5407a.f446497a[r100.ordinal()];
            goto L6
        }
    }

    public static EnumEntries<EnterSource> getEntries() {
        return f446496b;
    }

    static {
        EnterSource r100 = new EnterSource("Favorite", 0, 1);
        Favorite = r100;
        EnterSource r101 = new EnterSource("Mark", 1, 2);
        Mark = r101;
        EnterSource r102 = new EnterSource(ServiceType.IM, 2, 3);
        Message = r102;
        EnterSource[] r103 = {r100, r101, r102};
        f446495a = r103;
        f446496b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static EnterSource[] values() {
        return (EnterSource[]) f446495a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static EnterSource valueOf(String r100) {
        return (EnterSource) r27.a.a(EnterSource.class, r100);
    }

    public EnterSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
