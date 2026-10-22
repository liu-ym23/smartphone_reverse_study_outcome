package com.obric.assistant.ability;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/obric/assistant/ability/ObricSpecialInputScene;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "OAUTO_GUI", "OAUTO_TIMER_TASK", "COMPLEX_TASK", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricSpecialInputScene extends Enum<ObricSpecialInputScene> {
    public static final ObricSpecialInputScene COMPLEX_TASK = null;
    public static final a Companion = null;
    public static final ObricSpecialInputScene OAUTO_GUI = null;
    public static final ObricSpecialInputScene OAUTO_TIMER_TASK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricSpecialInputScene[] f385213a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f385214b = null;
    private final String type;

    public static final class a {
        public a() {
        }

        public static ObricSpecialInputScene a(String r100) {
            Iterator<ObricSpecialInputScene> r101 = ObricSpecialInputScene.getEntries().iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            ObricSpecialInputScene r102 = r101.next();
            if (Intrinsics.areEqual(r102.getType(), r100) == false) goto L4;
        L10:
            return r102;
        L8:
            r102 = null;
            goto L10
        }
    }

    public static EnumEntries<ObricSpecialInputScene> getEntries() {
        return f385214b;
    }

    static {
        ObricSpecialInputScene r100 = new ObricSpecialInputScene("OAUTO_GUI", 0, "auto_gui");
        OAUTO_GUI = r100;
        ObricSpecialInputScene r101 = new ObricSpecialInputScene("OAUTO_TIMER_TASK", 1, "auto_timer_task");
        OAUTO_TIMER_TASK = r101;
        ObricSpecialInputScene r102 = new ObricSpecialInputScene("COMPLEX_TASK", 2, "complex_task");
        COMPLEX_TASK = r102;
        ObricSpecialInputScene[] r103 = {r100, r101, r102};
        f385213a = r103;
        f385214b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static ObricSpecialInputScene[] values() {
        return (ObricSpecialInputScene[]) f385213a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static ObricSpecialInputScene valueOf(String r100) {
        return (ObricSpecialInputScene) r27.a.a(ObricSpecialInputScene.class, r100);
    }

    public ObricSpecialInputScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
