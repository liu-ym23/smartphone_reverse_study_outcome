package com.larus.network.ttnet;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Iterator;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.network.ttnet.OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1", f = "OpaqueData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CertificateFactory $certificateFactory;
    final /* synthetic */ Ref.IntRef $certificateNumber;
    final /* synthetic */ KeyStore $keyStore;
    final /* synthetic */ ArrayList<byte[]> $opaqueDataList;
    int label;

    public OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1(ArrayList<byte[]> r100, CertificateFactory r101, KeyStore r102, Ref.IntRef r103, Continuation<? super OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1> r104) {
        this.$opaqueDataList = r100;
        this.$certificateFactory = r101;
        this.$keyStore = r102;
        this.$certificateNumber = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1(this.$opaqueDataList, this.$certificateFactory, this.$keyStore, this.$certificateNumber, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r100);
        Iterator<byte[]> r101 = this.$opaqueDataList.iterator();
    L6:
        if (r101.hasNext() == false) goto L12;
        Certificate r102 = this.$certificateFactory.generateCertificate(new ByteArrayInputStream(r101.next()));     // Catch: Exception -> L10
        this.$keyStore.setCertificateEntry("CA-" + this.$certificateNumber.element, r102);     // Catch: Exception -> L10
        Ref.IntRef r103 = this.$certificateNumber;     // Catch: Exception -> L10
        r103.element = r103.element + 1;     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Boxing.boxInt(Log.d("URLConn Init", "failed with " + e));
        goto L6
    L12:
        TrustManagerFactory r104 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        r104.init(this.$keyStore);
        SSLContext r105 = SSLContext.getInstance("TLS");
        r105.init(null, r104.getTrustManagers(), new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(r105.getSocketFactory());
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
