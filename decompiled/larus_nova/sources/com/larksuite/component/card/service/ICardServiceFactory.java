package com.larksuite.component.card.service;

import com.larksuite.component.card.service.c;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
public interface ICardServiceFactory<T extends c> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/component/card/service/ICardServiceFactory$Scope;", "", "<init>", "(Ljava/lang/String;I)V", "CARD", "LIFECYCLE", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Scope extends Enum<Scope> {
        public static final Scope CARD = null;
        public static final Scope LIFECYCLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Scope[] f283922a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f283923b = null;

        public static EnumEntries<Scope> getEntries() {
            return f283923b;
        }

        static {
            Scope r100 = new Scope("CARD", 0);
            CARD = r100;
            Scope r101 = new Scope("LIFECYCLE", 1);
            LIFECYCLE = r101;
            Scope[] r102 = {r100, r101};
            f283922a = r102;
            f283923b = EnumEntriesKt.enumEntries(r102);
        }

        public static Scope[] values() {
            return (Scope[]) f283922a.clone();
        }

        public static Scope valueOf(String r100) {
            return (Scope) r27.a.a(Scope.class, r100);
        }

        public Scope(String r100, int r101) {
            super(r100, r101);
        }
    }

    Scope a();

    T b(b r100);
}
