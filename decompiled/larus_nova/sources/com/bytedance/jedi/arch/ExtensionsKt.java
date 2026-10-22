package com.bytedance.jedi.arch;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ae\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\f\b\u0000\u0010\u0007*\u00020\b*\u00020\t\"\u0010\b\u0001\u0010\u0006\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u000b0\n\"\b\b\u0002\u0010\u000b*\u00020\f*\u0002H\u00072\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000e2\u000e\b\u0006\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001ae\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\f\b\u0000\u0010\u0007*\u00020\b*\u00020\t\"\u0010\b\u0001\u0010\u0006\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u000b0\n\"\b\b\u0002\u0010\u000b*\u00020\f*\u0002H\u00072\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000e2\u000e\b\u0006\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001ae\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\f\b\u0000\u0010\u0007*\u00020\b*\u00020\t\"\u0010\b\u0001\u0010\u0006\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u000b0\n\"\b\b\u0002\u0010\u000b*\u00020\f*\u0002H\u00072\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000e2\u000e\b\u0006\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a\u0090\u0001\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0016\"\u0014\b\u0000\u0010\u0007*\u00020\u0017*\u00020\t*\u0006\u0012\u0002\b\u00030\u0018\"\u0010\b\u0001\u0010\u0006\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u000b0\n\"\b\b\u0002\u0010\u000b*\u00020\f*\u0002H\u00072\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000e2\u000e\b\u0006\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102!\b\n\u0010\u0019\u001a\u001b\u0012\u0004\u0012\u0002H\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0004\u0012\u0002H\u000b0\u001a¢\u0006\u0002\b\u001cH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001a\u0090\u0001\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0016\"\u0014\b\u0000\u0010\u0007*\u00020\b*\u00020\t*\u0006\u0012\u0002\b\u00030\u0018\"\u0010\b\u0001\u0010\u0006\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u000b0\n\"\b\b\u0002\u0010\u000b*\u00020\f*\u0002H\u00072\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000e2\u000e\b\n\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102!\b\n\u0010\u0019\u001a\u001b\u0012\u0004\u0012\u0002H\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0004\u0012\u0002H\u000b0\u001a¢\u0006\u0002\b\u001cH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001e\"\u0016\u0010\u0000\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, d2 = {"assertionFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getAssertionFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "activityViewModel", "Lkotlin/Lazy;", "VM", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/jedi/arch/JediView;", "Lcom/bytedance/jedi/arch/JediViewModel;", ExifInterface.LATITUDE_SOUTH, "Lcom/bytedance/jedi/arch/State;", "viewModelClass", "Lkotlin/reflect/KClass;", "keyFactory", "Lkotlin/Function0;", "", "(Landroidx/fragment/app/Fragment;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;", "hostViewModel", "parentFragmentViewModel", "viewModel", "Lcom/bytedance/jedi/arch/lifecycleAwareLazy;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/bytedance/jedi/arch/ViewModelFactoryOwner;", "argumentsAcceptor", "Lkotlin/Function2;", "Landroid/os/Bundle;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/appcompat/app/AppCompatActivity;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)Lcom/bytedance/jedi/arch/lifecycleAwareLazy;", "(Landroidx/fragment/app/Fragment;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)Lcom/bytedance/jedi/arch/lifecycleAwareLazy;", "arch_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ExtensionsKt {
    private static final ViewModelProvider.Factory assertionFactory = null;

    /* JADX INFO: Add missing generic type declarations: [VM] */
    /* JADX INFO: renamed from: com.bytedance.jedi.arch.ExtensionsKt$activityViewModel$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\f\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004\"\u0010\b\u0001\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0002\u0010\u0006*\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "VM", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/jedi/arch/JediView;", "Lcom/bytedance/jedi/arch/JediViewModel;", ExifInterface.LATITUDE_SOUTH, "Lcom/bytedance/jedi/arch/State;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/jedi/arch/JediViewModel;"}, k = 3, mv = {1, 7, 1}, xi = 176)
    public static final class AnonymousClass2<VM> extends Lambda implements Function0<VM> {
        final /* synthetic */ Function0<String> $keyFactory;

        /* JADX INFO: Incorrect field signature: TT; */
        final /* synthetic */ Fragment $this_activityViewModel;
        final /* synthetic */ KClass<VM> $viewModelClass;

        /* JADX WARN: Incorrect types in method signature: (TT;Lkotlin/jvm/functions/Function0<Ljava/lang/String;>;Lkotlin/reflect/KClass<TVM;>;)V */
        public AnonymousClass2(Fragment r100, Function0 r101, KClass r102) {
            this.$this_activityViewModel = r100;
            this.$keyFactory = r101;
            this.$viewModelClass = r102;
            super(0);
        }

        /* JADX WARN: Incorrect return type in method signature: ()TVM; */
        @Override // kotlin.jvm.functions.Function0
        public final JediViewModel invoke() {
            return (JediViewModel) ViewModelProviders.of(this.$this_activityViewModel.requireActivity(), ExtensionsKt.getAssertionFactory()).get(this.$keyFactory.invoke(), JvmClassMappingKt.getJavaClass(this.$viewModelClass));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return invoke();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [VM] */
    /* JADX INFO: renamed from: com.bytedance.jedi.arch.ExtensionsKt$hostViewModel$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\f\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004\"\u0010\b\u0001\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0002\u0010\u0006*\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "VM", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/jedi/arch/JediView;", "Lcom/bytedance/jedi/arch/JediViewModel;", ExifInterface.LATITUDE_SOUTH, "Lcom/bytedance/jedi/arch/State;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/jedi/arch/JediViewModel;"}, k = 3, mv = {1, 7, 1}, xi = 176)
    public static final class C105812<VM> extends Lambda implements Function0<VM> {
        final /* synthetic */ Function0<String> $keyFactory;

        /* JADX INFO: Incorrect field signature: TT; */
        final /* synthetic */ Fragment $this_hostViewModel;
        final /* synthetic */ KClass<VM> $viewModelClass;

        /* JADX WARN: Incorrect types in method signature: (TT;Lkotlin/jvm/functions/Function0<Ljava/lang/String;>;Lkotlin/reflect/KClass<TVM;>;)V */
        public C105812(Fragment r100, Function0 r101, KClass r102) {
            this.$this_hostViewModel = r100;
            this.$keyFactory = r101;
            this.$viewModelClass = r102;
            super(0);
        }

        /* JADX WARN: Incorrect return type in method signature: ()TVM; */
        @Override // kotlin.jvm.functions.Function0
        public final JediViewModel invoke() {
            Fragment r100 = this.$this_hostViewModel.getParentFragment();
            String r101 = this.$keyFactory.invoke();
        L3:
            if (r100 == null) goto L7;
            JediViewModel r102 = (JediViewModel) ViewModelProviders.of(r100, ExtensionsKt.getAssertionFactory()).get(r101, JvmClassMappingKt.getJavaClass(this.$viewModelClass));     // Catch: ViewModelNotCreatedException -> L6
        L8:
            if (r102 == null) goto L10;
            return r102;
        L10:
            return (JediViewModel) ViewModelProviders.of(this.$this_hostViewModel.requireActivity(), ExtensionsKt.getAssertionFactory()).get(r101, JvmClassMappingKt.getJavaClass(this.$viewModelClass));
        L6:
            r100 = r100.getParentFragment();
            goto L3
        L7:
            r102 = null;
            goto L8
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return invoke();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [VM] */
    /* JADX INFO: renamed from: com.bytedance.jedi.arch.ExtensionsKt$parentFragmentViewModel$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\f\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004\"\u0010\b\u0001\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0002\u0010\u0006*\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "VM", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/jedi/arch/JediView;", "Lcom/bytedance/jedi/arch/JediViewModel;", ExifInterface.LATITUDE_SOUTH, "Lcom/bytedance/jedi/arch/State;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/jedi/arch/JediViewModel;"}, k = 3, mv = {1, 7, 1}, xi = 176)
    public static final class C105832<VM> extends Lambda implements Function0<VM> {
        final /* synthetic */ Function0<String> $keyFactory;

        /* JADX INFO: Incorrect field signature: TT; */
        final /* synthetic */ Fragment $this_parentFragmentViewModel;
        final /* synthetic */ KClass<VM> $viewModelClass;

        /* JADX WARN: Incorrect types in method signature: (TT;Lkotlin/jvm/functions/Function0<Ljava/lang/String;>;Lkotlin/reflect/KClass<TVM;>;)V */
        public C105832(Fragment r100, Function0 r101, KClass r102) {
            this.$this_parentFragmentViewModel = r100;
            this.$keyFactory = r101;
            this.$viewModelClass = r102;
            super(0);
        }

        /* JADX WARN: Incorrect return type in method signature: ()TVM; */
        @Override // kotlin.jvm.functions.Function0
        public final JediViewModel invoke() {
            Fragment r100 = this.$this_parentFragmentViewModel.getParentFragment();
            Intrinsics.checkNotNull(r100);
            return (JediViewModel) ViewModelProviders.of(r100, ExtensionsKt.getAssertionFactory()).get(this.$keyFactory.invoke(), JvmClassMappingKt.getJavaClass(this.$viewModelClass));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return invoke();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [VM] */
    /* JADX INFO: renamed from: com.bytedance.jedi.arch.ExtensionsKt$viewModel$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0014\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0005\"\u0010\b\u0001\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\b\b\u0002\u0010\u0007*\u00020\bH\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", "VM", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/bytedance/jedi/arch/JediView;", "Lcom/bytedance/jedi/arch/ViewModelFactoryOwner;", "Lcom/bytedance/jedi/arch/JediViewModel;", ExifInterface.LATITUDE_SOUTH, "Lcom/bytedance/jedi/arch/State;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/jedi/arch/JediViewModel;"}, k = 3, mv = {1, 7, 1}, xi = 176)
    public static final class AnonymousClass3<VM> extends Lambda implements Function0<VM> {
        final /* synthetic */ Function2<S, Bundle, S> $argumentsAcceptor;
        final /* synthetic */ Function0<String> $keyFactory;

        /* JADX INFO: Incorrect field signature: TT; */
        final /* synthetic */ AppCompatActivity $this_viewModel;
        final /* synthetic */ KClass<VM> $viewModelClass;

        /* JADX WARN: Incorrect types in method signature: (TT;Lkotlin/jvm/functions/Function0<Ljava/lang/String;>;Lkotlin/reflect/KClass<TVM;>;Lkotlin/jvm/functions/Function2<-TS;-Landroid/os/Bundle;+TS;>;)V */
        public AnonymousClass3(AppCompatActivity r100, Function0 r101, KClass r102, Function2 r103) {
            this.$this_viewModel = r100;
            this.$keyFactory = r101;
            this.$viewModelClass = r102;
            this.$argumentsAcceptor = r103;
            super(0);
        }

        /* JADX WARN: Incorrect return type in method signature: ()TVM; */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function0
        public final JediViewModel invoke() {
            AppCompatActivity r100 = this.$this_viewModel;
            ViewModel r101 = ViewModelProviders.of(r100, ((ViewModelFactoryOwner) r100).getViewModelFactory()).get(this.$keyFactory.invoke(), JvmClassMappingKt.getJavaClass(this.$viewModelClass));
            final Function2<S, Bundle, S> r102 = this.$argumentsAcceptor;
            final AppCompatActivity r103 = this.$this_viewModel;
            JediViewModel r104 = (JediViewModel) r101;
            MiddlewareBindingFactory r105 = r104.getBindingFactory();
            Intrinsics.reifiedOperationMarker(4, "VM");
            MiddlewareBinding r106 = r105.create(JediViewModel.class);
            if (r106 == null) goto L5;
            r106.binding(r104);
        L5:
            r104.initialize(new ExtensionsKt$viewModel$3$1$1(r102, r103));
            return r104;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return invoke();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [VM] */
    /* JADX INFO: renamed from: com.bytedance.jedi.arch.ExtensionsKt$viewModel$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0014\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0005\"\u0010\b\u0001\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\b\b\u0002\u0010\u0007*\u00020\bH\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", "VM", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/jedi/arch/JediView;", "Lcom/bytedance/jedi/arch/ViewModelFactoryOwner;", "Lcom/bytedance/jedi/arch/JediViewModel;", ExifInterface.LATITUDE_SOUTH, "Lcom/bytedance/jedi/arch/State;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/jedi/arch/JediViewModel;"}, k = 3, mv = {1, 7, 1}, xi = 176)
    public static final class AnonymousClass6<VM> extends Lambda implements Function0<VM> {
        final /* synthetic */ Function2<S, Bundle, S> $argumentsAcceptor;
        final /* synthetic */ Function0<String> $keyFactory;

        /* JADX INFO: Incorrect field signature: TT; */
        final /* synthetic */ Fragment $this_viewModel;
        final /* synthetic */ KClass<VM> $viewModelClass;

        /* JADX WARN: Incorrect types in method signature: (TT;Lkotlin/jvm/functions/Function0<Ljava/lang/String;>;Lkotlin/reflect/KClass<TVM;>;Lkotlin/jvm/functions/Function2<-TS;-Landroid/os/Bundle;+TS;>;)V */
        public AnonymousClass6(Fragment r100, Function0 r101, KClass r102, Function2 r103) {
            this.$this_viewModel = r100;
            this.$keyFactory = r101;
            this.$viewModelClass = r102;
            this.$argumentsAcceptor = r103;
            super(0);
        }

        /* JADX WARN: Incorrect return type in method signature: ()TVM; */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function0
        public final JediViewModel invoke() {
            Fragment r100 = this.$this_viewModel;
            ViewModel r101 = ViewModelProviders.of(r100, ((ViewModelFactoryOwner) r100).getViewModelFactory()).get(this.$keyFactory.invoke(), JvmClassMappingKt.getJavaClass(this.$viewModelClass));
            final Function2<S, Bundle, S> r102 = this.$argumentsAcceptor;
            final Fragment r103 = this.$this_viewModel;
            JediViewModel r104 = (JediViewModel) r101;
            MiddlewareBindingFactory r105 = r104.getBindingFactory();
            Intrinsics.reifiedOperationMarker(4, "VM");
            MiddlewareBinding r106 = r105.create(JediViewModel.class);
            if (r106 == null) goto L5;
            r106.binding(r104);
        L5:
            r104.initialize(new ExtensionsKt$viewModel$6$1$1(r102, r103));
            return r104;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return invoke();
        }
    }

    static {
        assertionFactory = new ExtensionsKt$assertionFactory$1();
    }

    public static final ViewModelProvider.Factory getAssertionFactory() {
        return assertionFactory;
    }

    public static final /* synthetic */ <T extends Fragment & JediView, VM extends JediViewModel<S>, S extends State> Lazy<VM> activityViewModel(T r100, KClass<VM> r101, Function0<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "viewModelClass");
        Intrinsics.checkNotNullParameter(r102, "keyFactory");
        Intrinsics.needClassReification();
        return LazyKt.lazy(new AnonymousClass2(r100, r102, r101));
    }

    public static final /* synthetic */ <T extends Fragment & JediView, VM extends JediViewModel<S>, S extends State> Lazy<VM> hostViewModel(T r100, KClass<VM> r101, Function0<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "viewModelClass");
        Intrinsics.checkNotNullParameter(r102, "keyFactory");
        Intrinsics.needClassReification();
        return LazyKt.lazy(new C105812(r100, r102, r101));
    }

    public static final /* synthetic */ <T extends Fragment & JediView, VM extends JediViewModel<S>, S extends State> Lazy<VM> parentFragmentViewModel(T r100, KClass<VM> r101, Function0<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "viewModelClass");
        Intrinsics.checkNotNullParameter(r102, "keyFactory");
        Intrinsics.needClassReification();
        return LazyKt.lazy(new C105832(r100, r102, r101));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <T extends AppCompatActivity & JediView & ViewModelFactoryOwner<?>, VM extends JediViewModel<S>, S extends State> lifecycleAwareLazy<VM> viewModel(T r100, KClass<VM> r101, Function0<String> r102, Function2<? super S, ? super Bundle, ? extends S> r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "viewModelClass");
        Intrinsics.checkNotNullParameter(r102, "keyFactory");
        Intrinsics.checkNotNullParameter(r103, "argumentsAcceptor");
        Intrinsics.needClassReification();
        return new lifecycleAwareLazy(r100, new AnonymousClass3(r100, r102, r101, r103));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <T extends Fragment & JediView & ViewModelFactoryOwner<?>, VM extends JediViewModel<S>, S extends State> lifecycleAwareLazy<VM> viewModel(T r100, KClass<VM> r101, Function0<String> r102, Function2<? super S, ? super Bundle, ? extends S> r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "viewModelClass");
        Intrinsics.checkNotNullParameter(r102, "keyFactory");
        Intrinsics.checkNotNullParameter(r103, "argumentsAcceptor");
        Intrinsics.needClassReification();
        return new lifecycleAwareLazy(r100, r102, new AnonymousClass6(r100, r102, r101, r103));
    }

    public static /* synthetic */ Lazy activityViewModel$default(Fragment r100, final KClass r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        Intrinsics.reifiedOperationMarker(4, "VM");
        r101 = Reflection.getOrCreateKotlinClass(JediViewModel.class);
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = new AnonymousClass1(r101);
    L8:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "viewModelClass");
        Intrinsics.checkNotNullParameter(r102, "keyFactory");
        Intrinsics.needClassReification();
        return LazyKt.lazy(new AnonymousClass2(r100, r102, r101));
    }

    public static /* synthetic */ Lazy hostViewModel$default(Fragment r100, final KClass r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        Intrinsics.reifiedOperationMarker(4, "VM");
        r101 = Reflection.getOrCreateKotlinClass(JediViewModel.class);
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = new C105801(r101);
    L8:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "viewModelClass");
        Intrinsics.checkNotNullParameter(r102, "keyFactory");
        Intrinsics.needClassReification();
        return LazyKt.lazy(new C105812(r100, r102, r101));
    }

    public static /* synthetic */ Lazy parentFragmentViewModel$default(Fragment r100, final KClass r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        Intrinsics.reifiedOperationMarker(4, "VM");
        r101 = Reflection.getOrCreateKotlinClass(JediViewModel.class);
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = new C105821(r101);
    L8:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "viewModelClass");
        Intrinsics.checkNotNullParameter(r102, "keyFactory");
        Intrinsics.needClassReification();
        return LazyKt.lazy(new C105832(r100, r102, r101));
    }

    public static /* synthetic */ lifecycleAwareLazy viewModel$default(AppCompatActivity r100, final KClass r101, Function0 r102, Function2 r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        Intrinsics.reifiedOperationMarker(4, "VM");
        r101 = Reflection.getOrCreateKotlinClass(JediViewModel.class);
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = new C105841(r101);
    L9:
        if ((r104 & 4) == 0) goto L11;
        r103 = C105852.INSTANCE;
    L11:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "viewModelClass");
        Intrinsics.checkNotNullParameter(r102, "keyFactory");
        Intrinsics.checkNotNullParameter(r103, "argumentsAcceptor");
        Intrinsics.needClassReification();
        return new lifecycleAwareLazy(r100, new AnonymousClass3(r100, r102, r101, r103));
    }

    public static /* synthetic */ lifecycleAwareLazy viewModel$default(Fragment r100, final KClass r101, Function0 r102, Function2 r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        Intrinsics.reifiedOperationMarker(4, "VM");
        r101 = Reflection.getOrCreateKotlinClass(JediViewModel.class);
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = new AnonymousClass4(r101);
    L9:
        if ((r104 & 4) == 0) goto L11;
        r103 = AnonymousClass5.INSTANCE;
    L11:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "viewModelClass");
        Intrinsics.checkNotNullParameter(r102, "keyFactory");
        Intrinsics.checkNotNullParameter(r103, "argumentsAcceptor");
        Intrinsics.needClassReification();
        return new lifecycleAwareLazy(r100, r102, new AnonymousClass6(r100, r102, r101, r103));
    }
}
