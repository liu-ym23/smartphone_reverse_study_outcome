package ptc;

import io.opentelemetry.api.common.AttributeType;
import io.opentelemetry.api.internal.i;
import itc.e;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f530688a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f530689b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f530690c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i f530691d = null;

    static {
        e.b("browser.brands");
        e.c("browser.platform");
        i.a("browser.mobile", AttributeType.BOOLEAN);
        e.c("browser.language");
        e.c("cloud.provider");
        e.c("cloud.account.id");
        e.c("cloud.region");
        e.c("cloud.resource_id");
        e.c("cloud.availability_zone");
        e.c("cloud.platform");
        e.c("aws.ecs.container.arn");
        e.c("aws.ecs.cluster.arn");
        e.c("aws.ecs.launchtype");
        e.c("aws.ecs.task.arn");
        e.c("aws.ecs.task.family");
        e.c("aws.ecs.task.revision");
        e.c("aws.eks.cluster.arn");
        e.b("aws.log.group.names");
        e.b("aws.log.group.arns");
        e.b("aws.log.stream.names");
        e.b("aws.log.stream.arns");
        e.c("heroku.release.creation_timestamp");
        e.c("heroku.release.commit");
        e.c("heroku.app.id");
        e.c("container.name");
        e.c("container.id");
        e.c("container.runtime");
        e.c("container.image.name");
        e.c("container.image.tag");
        e.c("deployment.environment");
        e.c("device.id");
        e.c("device.model.identifier");
        e.c("device.model.name");
        e.c("device.manufacturer");
        e.c("faas.name");
        e.c("faas.version");
        e.c("faas.instance");
        e.a("faas.max_memory");
        e.c("host.id");
        e.c("host.name");
        e.c("host.type");
        e.c("host.arch");
        e.c("host.image.name");
        e.c("host.image.id");
        e.c("host.image.version");
        e.c("k8s.cluster.name");
        e.c("k8s.node.name");
        e.c("k8s.node.uid");
        e.c("k8s.namespace.name");
        e.c("k8s.pod.uid");
        e.c("k8s.pod.name");
        e.c("k8s.container.name");
        e.a("k8s.container.restart_count");
        e.c("k8s.replicaset.uid");
        e.c("k8s.replicaset.name");
        e.c("k8s.deployment.uid");
        e.c("k8s.deployment.name");
        e.c("k8s.statefulset.uid");
        e.c("k8s.statefulset.name");
        e.c("k8s.daemonset.uid");
        e.c("k8s.daemonset.name");
        e.c("k8s.job.uid");
        e.c("k8s.job.name");
        e.c("k8s.cronjob.uid");
        e.c("k8s.cronjob.name");
        e.c("os.type");
        e.c("os.description");
        e.c("os.name");
        e.c("os.version");
        e.a("process.pid");
        e.a("process.parent_pid");
        e.c("process.executable.name");
        e.c("process.executable.path");
        e.c("process.command");
        e.c("process.command_line");
        e.b("process.command_args");
        e.c("process.owner");
        e.c("process.runtime.name");
        e.c("process.runtime.version");
        e.c("process.runtime.description");
        f530688a = e.c("service.name");
        e.c("service.namespace");
        e.c("service.instance.id");
        e.c("service.version");
        f530689b = e.c("telemetry.sdk.name");
        f530690c = e.c("telemetry.sdk.language");
        f530691d = e.c("telemetry.sdk.version");
        e.c("telemetry.auto.version");
        e.c("webengine.name");
        e.c("webengine.version");
        e.c("webengine.description");
        e.c("otel.scope.name");
        e.c("otel.scope.version");
        e.c("otel.library.name");
        e.c("otel.library.version");
        e.c("browser.user_agent");
        e.c("faas.id");
    }
}
