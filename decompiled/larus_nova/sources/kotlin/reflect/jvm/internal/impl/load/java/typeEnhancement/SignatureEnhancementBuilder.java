package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* JADX INFO: loaded from: classes42.dex */
final class SignatureEnhancementBuilder {
    private final Map<String, PredefinedFunctionEnhancementInfo> signatures;

    public final class ClassEnhancementBuilder {
        private final String className;
        final /* synthetic */ SignatureEnhancementBuilder this$0;

        public final class FunctionEnhancementBuilder {
            private final String functionName;
            private final List<Pair<String, TypeEnhancementInfo>> parameters;
            private Pair<String, TypeEnhancementInfo> returnType;
            final /* synthetic */ ClassEnhancementBuilder this$0;

            public final Pair<String, PredefinedFunctionEnhancementInfo> build() {
                SignatureBuildingComponents r100 = SignatureBuildingComponents.INSTANCE;
                String r101 = this.this$0.getClassName();
                String r102 = this.functionName;
                List<Pair<String, TypeEnhancementInfo>> r103 = this.parameters;
                ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
                Iterator<T> r105 = r103.iterator();
            L4:
                if (r105.hasNext() == false) goto L6;
                r104.add((String) ((Pair) r105.next()).getFirst());
                goto L4
            L6:
                String r106 = r100.signature(r101, r100.jvmDescriptor(r102, r104, this.returnType.getFirst()));
                TypeEnhancementInfo r107 = this.returnType.getSecond();
                List<Pair<String, TypeEnhancementInfo>> r108 = this.parameters;
                ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
                Iterator<T> r110 = r108.iterator();
            L8:
                if (r110.hasNext() == false) goto L11;
                r109.add((TypeEnhancementInfo) ((Pair) r110.next()).getSecond());
                goto L8
            L11:
                return TuplesKt.to(r106, new PredefinedFunctionEnhancementInfo(r107, r109));
            }

            public final void returns(JvmPrimitiveType r100) {
                Intrinsics.checkNotNullParameter(r100, "type");
                this.returnType = TuplesKt.to(r100.getDesc(), null);
            }

            public FunctionEnhancementBuilder(ClassEnhancementBuilder r100, String r101) {
                Intrinsics.checkNotNullParameter(r101, "functionName");
                this.this$0 = r100;
                this.functionName = r101;
                this.parameters = new ArrayList();
                this.returnType = TuplesKt.to("V", null);
            }

            public final void parameter(String r100, JavaTypeQualifiers... r101) {
                Intrinsics.checkNotNullParameter(r100, "type");
                Intrinsics.checkNotNullParameter(r101, "qualifiers");
                List<Pair<String, TypeEnhancementInfo>> r102 = this.parameters;
                if (r101.length != 0) goto L5;
                boolean r103 = true;
            L6:
                if (r103 == false) goto L8;
                TypeEnhancementInfo r104 = null;
            L13:
                r102.add(TuplesKt.to(r100, r104));
                return;
            L8:
                Iterable r105 = ArraysKt.withIndex(r101);
                LinkedHashMap r106 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r105, 10)), 16));
                Iterator r107 = r105.iterator();
            L10:
                if (r107.hasNext() == false) goto L12;
                IndexedValue r108 = (IndexedValue) r107.next();
                r106.put(Integer.valueOf(r108.getIndex()), (JavaTypeQualifiers) r108.getValue());
                goto L10
            L12:
                r104 = new TypeEnhancementInfo(r106);
                goto L13
            L5:
                r103 = false;
                goto L6
            }

            public final void returns(String r100, JavaTypeQualifiers... r101) {
                Intrinsics.checkNotNullParameter(r100, "type");
                Intrinsics.checkNotNullParameter(r101, "qualifiers");
                Iterable r102 = ArraysKt.withIndex(r101);
                LinkedHashMap r103 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r102, 10)), 16));
                Iterator r104 = r102.iterator();
            L4:
                if (r104.hasNext() == false) goto L6;
                IndexedValue r105 = (IndexedValue) r104.next();
                r103.put(Integer.valueOf(r105.getIndex()), (JavaTypeQualifiers) r105.getValue());
                goto L4
            L6:
                this.returnType = TuplesKt.to(r100, new TypeEnhancementInfo(r103));
            }
        }

        public final String getClassName() {
            return this.className;
        }

        public ClassEnhancementBuilder(SignatureEnhancementBuilder r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, PushClientConstants.TAG_CLASS_NAME);
            this.this$0 = r100;
            this.className = r101;
        }

        public final void function(String r100, Function1<? super FunctionEnhancementBuilder, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, "block");
            Map r102 = SignatureEnhancementBuilder.access$getSignatures$p(this.this$0);
            FunctionEnhancementBuilder r103 = new FunctionEnhancementBuilder(this, r100);
            r101.invoke(r103);
            Pair<String, PredefinedFunctionEnhancementInfo> r104 = r103.build();
            r102.put(r104.getFirst(), r104.getSecond());
        }
    }

    public SignatureEnhancementBuilder() {
        this.signatures = new LinkedHashMap();
    }

    public final Map<String, PredefinedFunctionEnhancementInfo> build() {
        return this.signatures;
    }

    public static final /* synthetic */ Map access$getSignatures$p(SignatureEnhancementBuilder r100) {
        return r100.signatures;
    }
}
