package com.github.alexzhirkevich.customqrgenerator.vector.style;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R5\u0010\u0006\u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00050\u00038\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR5\u0010\n\u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00050\u00038\u0006¢\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"com/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor$LinearGradient$Orientation", "", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor$LinearGradient$Orientation;", "Lkotlin/Function2;", "", "Lkotlin/Pair;", "start", "Lkotlin/jvm/functions/Function2;", "getStart", "()Lkotlin/jvm/functions/Function2;", "end", "getEnd", "Vertical", "Horizontal", "LeftDiagonal", "RightDiagonal", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0})
public final enum QrVectorColor$LinearGradient$Orientation extends Enum<QrVectorColor$LinearGradient$Orientation> {
    public static final QrVectorColor$LinearGradient$Orientation Horizontal = null;
    public static final QrVectorColor$LinearGradient$Orientation LeftDiagonal = null;
    public static final QrVectorColor$LinearGradient$Orientation RightDiagonal = null;
    public static final QrVectorColor$LinearGradient$Orientation Vertical = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ QrVectorColor$LinearGradient$Orientation[] f274269a = null;
    private final Function2<Float, Float, Pair<Float, Float>> end;
    private final Function2<Float, Float, Pair<Float, Float>> start;

    public static QrVectorColor$LinearGradient$Orientation valueOf(String r100) {
        return (QrVectorColor$LinearGradient$Orientation) r27.a.a(QrVectorColor$LinearGradient$Orientation.class, r100);
    }

    public static QrVectorColor$LinearGradient$Orientation[] values() {
        return (QrVectorColor$LinearGradient$Orientation[]) f274269a.clone();
    }

    static {
        QrVectorColor$LinearGradient$Orientation r100 = new QrVectorColor$LinearGradient$Orientation("Vertical", 0, AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE);
        Vertical = r100;
        QrVectorColor$LinearGradient$Orientation r101 = new QrVectorColor$LinearGradient$Orientation("Horizontal", 1, AnonymousClass3.INSTANCE, AnonymousClass4.INSTANCE);
        Horizontal = r101;
        QrVectorColor$LinearGradient$Orientation r102 = new QrVectorColor$LinearGradient$Orientation("LeftDiagonal", 2, AnonymousClass5.INSTANCE, AnonymousClass6.INSTANCE);
        LeftDiagonal = r102;
        QrVectorColor$LinearGradient$Orientation r103 = new QrVectorColor$LinearGradient$Orientation("RightDiagonal", 3, AnonymousClass7.INSTANCE, AnonymousClass8.INSTANCE);
        RightDiagonal = r103;
        f274269a = new QrVectorColor$LinearGradient$Orientation[]{r100, r101, r102, r103};
    }

    public final Function2<Float, Float, Pair<Float, Float>> getEnd() {
        return this.end;
    }

    public final Function2<Float, Float, Pair<Float, Float>> getStart() {
        return this.start;
    }

    public QrVectorColor$LinearGradient$Orientation(String r100, int r101, Function2 r102, Function2 r103) {
        super(r100, r101);
        this.start = r102;
        this.end = r103;
    }
}
