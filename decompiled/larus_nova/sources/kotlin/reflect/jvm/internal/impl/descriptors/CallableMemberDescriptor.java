package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public interface CallableMemberDescriptor extends CallableDescriptor, MemberDescriptor {

    public static final enum Kind extends Enum<Kind> {
        private static final /* synthetic */ Kind[] $VALUES = null;
        public static final Kind DECLARATION = null;
        public static final Kind DELEGATION = null;
        public static final Kind FAKE_OVERRIDE = null;
        public static final Kind SYNTHESIZED = null;

        static {
            Kind r100 = new Kind("DECLARATION", 0);
            DECLARATION = r100;
            Kind r101 = new Kind("FAKE_OVERRIDE", 1);
            FAKE_OVERRIDE = r101;
            Kind r102 = new Kind("DELEGATION", 2);
            DELEGATION = r102;
            Kind r103 = new Kind("SYNTHESIZED", 3);
            SYNTHESIZED = r103;
            $VALUES = new Kind[]{r100, r101, r102, r103};
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }

        public boolean isReal() {
            if (this == FAKE_OVERRIDE) goto L5;
            return true;
        L5:
            return false;
        }

        public static Kind valueOf(String r100) {
            return (Kind) a.a(Kind.class, r100);
        }

        private Kind(String r100, int r101) {
            super(r100, r101);
        }
    }

    CallableMemberDescriptor copy(DeclarationDescriptor r100, Modality r101, DescriptorVisibility r102, Kind r103, boolean r104);

    Kind getKind();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    CallableMemberDescriptor getOriginal();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    Collection<? extends CallableMemberDescriptor> getOverriddenDescriptors();

    void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> r100);
}
