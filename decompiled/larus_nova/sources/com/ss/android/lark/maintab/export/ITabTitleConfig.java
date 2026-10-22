package com.ss.android.lark.maintab.export;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
public interface ITabTitleConfig {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/maintab/export/ITabTitleConfig$IconStyle;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "Hide", "Up", "Down", "Companion", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum IconStyle extends Enum<IconStyle> {
        public static final a Companion = null;
        public static final IconStyle Down = null;
        public static final IconStyle Hide = null;
        public static final IconStyle Up = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ IconStyle[] f431583a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f431584b = null;
        private final int number;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<IconStyle> getEntries() {
            return f431584b;
        }

        static {
            IconStyle r100 = new IconStyle("Hide", 0, 0);
            Hide = r100;
            IconStyle r101 = new IconStyle("Up", 1, 1);
            Up = r101;
            IconStyle r102 = new IconStyle("Down", 2, 2);
            Down = r102;
            IconStyle[] r103 = {r100, r101, r102};
            f431583a = r103;
            f431584b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static IconStyle[] values() {
            return (IconStyle[]) f431583a.clone();
        }

        public final int getNumber() {
            return this.number;
        }

        public static IconStyle valueOf(String r100) {
            return (IconStyle) r27.a.a(IconStyle.class, r100);
        }

        public IconStyle(String r100, int r101, int r102) {
            super(r100, r101);
            this.number = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/maintab/export/ITabTitleConfig$Status;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "Normal", "Loading", "Companion", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Status extends Enum<Status> {
        public static final a Companion = null;
        public static final Status Loading = null;
        public static final Status Normal = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f431585a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f431586b = null;
        private final int number;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<Status> getEntries() {
            return f431586b;
        }

        static {
            Status r100 = new Status("Normal", 0, 0);
            Normal = r100;
            Status r101 = new Status("Loading", 1, 1);
            Loading = r101;
            Status[] r102 = {r100, r101};
            f431585a = r102;
            f431586b = EnumEntriesKt.enumEntries(r102);
            Companion = new a();
        }

        public static Status[] values() {
            return (Status[]) f431585a.clone();
        }

        public final int getNumber() {
            return this.number;
        }

        public static Status valueOf(String r100) {
            return (Status) r27.a.a(Status.class, r100);
        }

        public Status(String r100, int r101, int r102) {
            super(r100, r101);
            this.number = r102;
        }
    }
}
