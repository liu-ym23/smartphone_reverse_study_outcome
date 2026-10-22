package kotlinx.datetime.internal.format;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.parser.b0;

/* JADX INFO: loaded from: classes42.dex */
public abstract class NamedUnsignedIntFieldFormatDirective<Target> implements k<Target> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w<Target> f505260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f505261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f505262c;

    public final class a implements kotlinx.datetime.internal.format.parser.a<Target, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NamedUnsignedIntFieldFormatDirective<Target> f505263a;

        @Override // kotlinx.datetime.internal.format.parser.a
        public final String getName() {
            return this.f505263a.f505262c;
        }

        public a(NamedUnsignedIntFieldFormatDirective r100) {
            this.f505263a = r100;
        }

        @Override // kotlinx.datetime.internal.format.parser.a
        public final String c(Object r100, String r101) {
            String r102 = r101;
            Intrinsics.checkNotNullParameter(r102, "newValue");
            NamedUnsignedIntFieldFormatDirective<Target> r103 = this.f505263a;
            Integer r104 = r103.f505260a.f505359a.c(r100, Integer.valueOf(r103.f505261b.indexOf(r102) + this.f505263a.f505260a.f505360b));
            if (r104 == null) goto L5;
            NamedUnsignedIntFieldFormatDirective<Target> r105 = this.f505263a;
            int r106 = r104.intValue();
            return (String) ListProtector.get(r105.f505261b, r106 - r105.f505260a.f505360b);
        L5:
            return null;
        }
    }

    @Override // kotlinx.datetime.internal.format.k
    public final huc.e<Target> a() {
        return new huc.i(new NamedUnsignedIntFieldFormatDirective$formatter$1(this));
    }

    @Override // kotlinx.datetime.internal.format.k
    public final kotlinx.datetime.internal.format.parser.u<Target> parser() {
        return new kotlinx.datetime.internal.format.parser.u(CollectionsKt.listOf(new b0(this.f505261b, new a(this), "one of " + this.f505261b + " for " + this.f505262c)), CollectionsKt.emptyList());
    }

    @Override // kotlinx.datetime.internal.format.k
    public final /* bridge */ /* synthetic */ m b() {
        return this.f505260a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NamedUnsignedIntFieldFormatDirective(w<? super Target> r100, List<String> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "field");
        Intrinsics.checkNotNullParameter(r101, "values");
        Intrinsics.checkNotNullParameter(r102, "name");
        this.f505260a = r100;
        this.f505261b = r101;
        this.f505262c = r102;
        if (r101.size() != ((r100.f505361c - r100.f505360b) + 1)) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(("The number of values (" + r101.size() + ") in " + r101 + " does not match the range of the field (" + ((r100.f505361c - r100.f505360b) + 1) + ')').toString());
    L5:
        r103 = false;
        goto L6
    }
}
