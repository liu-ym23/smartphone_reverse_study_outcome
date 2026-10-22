package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.bubble;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public interface IBubbleBodyBgStyleProvider {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/message/cellv2/layout/bubble/IBubbleBodyBgStyleProvider$Style;", "", "<init>", "(Ljava/lang/String;I)V", "Normal", "Clean", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Style extends Enum<Style> {
        public static final Style Clean = null;
        public static final Style Normal = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Style[] f413321a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f413322b = null;

        public static EnumEntries<Style> getEntries() {
            return f413322b;
        }

        static {
            Style r100 = new Style("Normal", 0);
            Normal = r100;
            Style r101 = new Style("Clean", 1);
            Clean = r101;
            Style[] r102 = {r100, r101};
            f413321a = r102;
            f413322b = EnumEntriesKt.enumEntries(r102);
        }

        public static Style[] values() {
            return (Style[]) f413321a.clone();
        }

        public static Style valueOf(String r100) {
            return (Style) a.a(Style.class, r100);
        }

        public Style(String r100, int r101) {
            super(r100, r101);
        }
    }

    Style m();
}
