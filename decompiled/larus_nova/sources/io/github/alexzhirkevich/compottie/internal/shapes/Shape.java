package io.github.alexzhirkevich.compottie.internal.shapes;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.json.JsonClassDiscriminator;

/* JADX INFO: loaded from: classes41.dex */
@JsonClassDiscriminator(discriminator = "ty")
@Serializable
public interface Shape extends zrc.a {
    public static final a Companion = null;

    @Serializable
    public static final class UnsupportedShape implements Shape {
        public static final a Companion = null;

        public static final class a {
            public a() {
            }

            public final juc.d<UnsupportedShape> serializer() {
                return Shape$UnsupportedShape$$serializer.f491530a;
            }
        }

        public UnsupportedShape() {
        }

        @Override // zrc.a
        public final void b(List<? extends zrc.a> r100, List<? extends zrc.a> r101) {
            Intrinsics.checkNotNullParameter(r100, "contentsBefore");
            Intrinsics.checkNotNullParameter(r101, "contentsAfter");
        }

        @Override // zrc.a
        public final String getName() {
            return null;
        }

        @Override // io.github.alexzhirkevich.compottie.internal.shapes.Shape
        public final void p(String r100, orc.j r101) {
        }

        static {
            Companion = new a();
        }

        @Override // io.github.alexzhirkevich.compottie.internal.shapes.Shape
        public final Shape deepCopy() {
            return new UnsupportedShape();
        }

        public UnsupportedShape(int r100) {
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f491532a = null;

        static {
            f491532a = new a();
        }

        public a() {
        }

        public final juc.d<Shape> serializer() {
            return new juc.l("io.github.alexzhirkevich.compottie.internal.shapes.Shape", Reflection.getOrCreateKotlinClass(Shape.class), new KClass[]{Reflection.getOrCreateKotlinClass(EllipseShape.class), Reflection.getOrCreateKotlinClass(FillShape.class), Reflection.getOrCreateKotlinClass(GradientFillShape.class), Reflection.getOrCreateKotlinClass(GradientStrokeShape.class), Reflection.getOrCreateKotlinClass(GroupShape.class), Reflection.getOrCreateKotlinClass(MergePathsShape.class), Reflection.getOrCreateKotlinClass(PathShape.class), Reflection.getOrCreateKotlinClass(PolystarShape.class), Reflection.getOrCreateKotlinClass(RectShape.class), Reflection.getOrCreateKotlinClass(RepeaterShape.class), Reflection.getOrCreateKotlinClass(RoundShape.class), Reflection.getOrCreateKotlinClass(UnsupportedShape.class), Reflection.getOrCreateKotlinClass(SolidStrokeShape.class), Reflection.getOrCreateKotlinClass(TransformShape.class), Reflection.getOrCreateKotlinClass(TrimPathShape.class)}, new juc.d[]{EllipseShape$$serializer.f491398a, FillShape$$serializer.f491416a, GradientFillShape$$serializer.f491437a, GradientStrokeShape$$serializer.f491452a, GroupShape.a.f491461a, MergePathsShape$$serializer.f491471a, PathShape$$serializer.f491481a, PolystarShape$$serializer.f491499a, RectShape$$serializer.f491510a, RepeaterShape$$serializer.f491522a, RoundShape$$serializer.f491528a, Shape$UnsupportedShape$$serializer.f491530a, SolidStrokeShape$$serializer.f491544a, TransformShape$$serializer.f491559a, TrimPathShape$$serializer.f491568a}, new Annotation[]{new Shape$UnsupportedShape$$serializer$annotationImpl$kotlinx_serialization_json_JsonClassDiscriminator$0("ty")});
        }
    }

    static {
        Companion = a.f491532a;
    }

    boolean a();

    Shape deepCopy();

    void p(String r100, orc.j r101);
}
