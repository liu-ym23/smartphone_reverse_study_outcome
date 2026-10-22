package com.larus.asr.direct;

import com.larus.audio.asr.c0;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import m1a.a;

/* JADX INFO: loaded from: classes4.dex */
public interface IAsrDirectFillAbility extends a {

    /* JADX INFO: loaded from: classes24.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/asr/direct/IAsrDirectFillAbility$DirectFillStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FillBackClickSend", "FillBackEdit", "FillBackClear", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DirectFillStatus extends Enum<DirectFillStatus> {
        public static final a Companion = null;
        public static final DirectFillStatus FillBackClear = null;
        public static final DirectFillStatus FillBackClickSend = null;
        public static final DirectFillStatus FillBackEdit = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DirectFillStatus[] f287258a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f287259b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<DirectFillStatus> getEntries() {
            return f287259b;
        }

        static {
            DirectFillStatus r100 = new DirectFillStatus("FillBackClickSend", 0, 1);
            FillBackClickSend = r100;
            DirectFillStatus r101 = new DirectFillStatus("FillBackEdit", 1, 2);
            FillBackEdit = r101;
            DirectFillStatus r102 = new DirectFillStatus("FillBackClear", 2, 3);
            FillBackClear = r102;
            DirectFillStatus[] r103 = {r100, r101, r102};
            f287258a = r103;
            f287259b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static DirectFillStatus[] values() {
            return (DirectFillStatus[]) f287258a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static DirectFillStatus valueOf(String r100) {
            return (DirectFillStatus) r27.a.a(DirectFillStatus.class, r100);
        }

        public DirectFillStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    void Il();

    void R30();

    void S60();

    DirectFillStatus VY();

    void YZ(String r100);

    void cancel();

    void il(boolean r100, c0 r101);

    void mR(String r100);

    boolean oQ();

    String xl();
}
