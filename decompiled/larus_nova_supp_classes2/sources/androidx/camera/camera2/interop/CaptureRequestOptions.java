package androidx.camera.camera2.interop;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.core.ExtendableBuilder;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.ReadableConfig;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class CaptureRequestOptions implements ReadableConfig {
    private final Config mConfig;

    public static final class Builder implements ExtendableBuilder<CaptureRequestOptions> {
        private final MutableOptionsBundle mMutableOptionsBundle;

        public static /* synthetic */ boolean a(Builder r0, Config r1, Config.Option r2) {
            return lambda$from$0(r0, r1, r2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.ExtendableBuilder
        public CaptureRequestOptions build() {
            return new CaptureRequestOptions(OptionsBundle.from(this.mMutableOptionsBundle));
        }

        public Builder() {
            this.mMutableOptionsBundle = MutableOptionsBundle.create();
        }

        @Override // androidx.camera.core.ExtendableBuilder
        public MutableConfig getMutableConfig() {
            return this.mMutableOptionsBundle;
        }

        @Override // androidx.camera.core.ExtendableBuilder
        public /* bridge */ /* synthetic */ CaptureRequestOptions build() {
            return build();
        }

        public static Builder from(final Config r3) {
            final Builder r0 = new Builder();
            r3.findOptions(Camera2ImplConfig.CAPTURE_REQUEST_ID_STEM, new i(r0, r3));
            return r0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <ValueT> Builder clearCaptureRequestOption(CaptureRequest.Key<ValueT> r2) {
            Config.Option<Object> r3 = Camera2ImplConfig.createCaptureRequestOption(r2);
            this.mMutableOptionsBundle.removeOption(r3);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <ValueT> Builder setCaptureRequestOption(CaptureRequest.Key<ValueT> r2, ValueT r3) {
            Config.Option<Object> r4 = Camera2ImplConfig.createCaptureRequestOption(r2);
            this.mMutableOptionsBundle.insertOption(r4, r3);
            return this;
        }

        private static /* synthetic */ boolean lambda$from$0(Builder r1, Config r2, Config.Option r3) {
            r1.getMutableConfig().insertOption(r3, r2.getOptionPriority(r3), r2.retrieveOption(r3));
            return true;
        }
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ boolean containsOption(Config.Option r1) {
        return ReadableConfig.CC.$default$containsOption(this, r1);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ void findOptions(String r1, Config.OptionMatcher r2) {
        ReadableConfig.CC.$default$findOptions(this, r1, r2);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Config.OptionPriority getOptionPriority(Config.Option r1) {
        return ReadableConfig.CC.$default$getOptionPriority(this, r1);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Set getPriorities(Config.Option r1) {
        return ReadableConfig.CC.$default$getPriorities(this, r1);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Set listOptions() {
        return ReadableConfig.CC.$default$listOptions(this);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Object retrieveOption(Config.Option r1) {
        return ReadableConfig.CC.$default$retrieveOption(this, r1);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Object retrieveOption(Config.Option r1, Object r2) {
        return ReadableConfig.CC.$default$retrieveOption(this, r1, r2);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Object retrieveOptionWithPriority(Config.Option r1, Config.OptionPriority r2) {
        return ReadableConfig.CC.$default$retrieveOptionWithPriority(this, r1, r2);
    }

    @Override // androidx.camera.core.impl.ReadableConfig
    public Config getConfig() {
        return this.mConfig;
    }

    public CaptureRequestOptions(Config r1) {
        this.mConfig = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <ValueT> ValueT getCaptureRequestOption(CaptureRequest.Key<ValueT> r3) {
        Config.Option<Object> r4 = Camera2ImplConfig.createCaptureRequestOption(r3);
        return (ValueT) this.mConfig.retrieveOption(r4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <ValueT> ValueT getCaptureRequestOption(CaptureRequest.Key<ValueT> r2, ValueT r3) {
        Config.Option<Object> r4 = Camera2ImplConfig.createCaptureRequestOption(r2);
        return (ValueT) this.mConfig.retrieveOption(r4, r3);
    }
}
