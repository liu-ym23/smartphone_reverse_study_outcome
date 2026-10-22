package com.larus.common_ui.dbx.theme;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class DbxTheme {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DbxTheme f327081a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f327082b;

    /* JADX INFO: loaded from: classes27.dex */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/common_ui/dbx/theme/DbxTheme$Variant;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "LIGHT", "DARK", UserProfileEvent.POSITION_NONE, "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Variant extends Enum<Variant> {
        public static final Variant DARK = null;
        public static final Variant DEFAULT = null;
        public static final Variant LIGHT = null;
        public static final Variant NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Variant[] f327083a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f327084b = null;

        public static EnumEntries<Variant> getEntries() {
            return f327084b;
        }

        static {
            Variant r100 = new Variant("DEFAULT", 0);
            DEFAULT = r100;
            Variant r101 = new Variant("LIGHT", 1);
            LIGHT = r101;
            Variant r102 = new Variant("DARK", 2);
            DARK = r102;
            Variant r103 = new Variant(UserProfileEvent.POSITION_NONE, 3);
            NONE = r103;
            Variant[] r104 = {r100, r101, r102, r103};
            f327083a = r104;
            f327084b = EnumEntriesKt.enumEntries(r104);
        }

        public static Variant[] values() {
            return (Variant[]) f327083a.clone();
        }

        public static Variant valueOf(String r100) {
            return (Variant) r27.a.a(Variant.class, r100);
        }

        public Variant(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
    }

    static {
        f327081a = new DbxTheme();
    }

    public DbxTheme() {
    }
}
